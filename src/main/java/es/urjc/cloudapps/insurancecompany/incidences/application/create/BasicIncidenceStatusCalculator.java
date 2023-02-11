package es.urjc.cloudapps.insurancecompany.incidences.application.create;

import es.urjc.cloudapps.insurancecompany.incidences.domain.*;
import es.urjc.cloudapps.insurancecompany.insurances.domain.*;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class BasicIncidenceStatusCalculator implements IncidenceStatusCalculatorStrategy {

    private final InsuranceRepository insuranceRepository;
    private final IncidenceRepository incidenceRepository;
    private final CoverageRepository  coverageRepository;

    public BasicIncidenceStatusCalculator(final InsuranceRepository insuranceRepository,
                                          final IncidenceRepository incidenceRepository,
                                          final CoverageRepository coverageRepository) {

        this.insuranceRepository = insuranceRepository;
        this.incidenceRepository = incidenceRepository;
        this.coverageRepository  = coverageRepository;
    }

    @Override
    @Transactional
    public IncidenceStatus calculateStatus(final InsuranceId insuranceId,
                                           final CoverageIncidenceId coverageIncidenceId) {

        if (isFraud(insuranceId)) {
            return IncidenceStatus.SUSPICION_OF_FRAUD;
        }

        if (isNotCovered(insuranceId, coverageIncidenceId)) {
            return IncidenceStatus.NOT_COVERED;
        }

        return IncidenceStatus.ACCEPTED;
    }

    private boolean isFraud(final InsuranceId insuranceId) {

        final List<Incidence> incidences = incidenceRepository.findByInsuranceId(insuranceId);

        if (!incidences.isEmpty() && incidences.size() >= 2) {
            final BigDecimal bd = incidences.stream().map(i -> i.getAmount().getAmount()).reduce(BigDecimal.ZERO,
                    BigDecimal::add);
            return bd.compareTo(BigDecimal.valueOf(1000)) > 0;
        } else {
            return Boolean.FALSE;
        }
    }

    private boolean isNotCovered(final InsuranceId insuranceId,
                                 final CoverageIncidenceId coverageIncidenceId) {

        final Insurance     insurance = insuranceRepository.findOne(insuranceId);
        final Set<Coverage> coverages = insurance.getCoverages();

        for (Coverage c : coverages) {
            Coverage coverage = coverageRepository.findById(c.getName());
            if (coverage.getCoverageIncidences().contains(new CoverageIncidence(coverageIncidenceId))) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}
