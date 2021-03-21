package es.urjc.cloudapps.insurancecompany.incidences.application.create;

import es.urjc.cloudapps.insurancecompany.incidences.domain.*;
import es.urjc.cloudapps.insurancecompany.insurances.domain.Insurance;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceRepository;
import org.springframework.stereotype.Service;

@Service
public class IncidenceCreator {

    private final IncidenceRepository               incidenceRepository;
    private final InsuranceRepository               insuranceRepository;
    private final CoverageIncidenceRepository       coverageIncidenceRepository;
    private final IncidenceStatusCalculatorStrategy statusCalculatorStrategy;

    public IncidenceCreator(final IncidenceRepository incidenceRepository,
                            final InsuranceRepository insuranceRepository,
                            final CoverageIncidenceRepository coverageIncidenceRepository,
                            final IncidenceStatusCalculatorStrategy statusCalculatorStrategy) {

        this.incidenceRepository         = incidenceRepository;
        this.insuranceRepository         = insuranceRepository;
        this.coverageIncidenceRepository = coverageIncidenceRepository;
        this.statusCalculatorStrategy    = statusCalculatorStrategy;
    }

    public void create(final CreateIncidenceCommand command) {
        ensureInsuranceExists(command.getInsuranceId());
        ensureCoverageIncidenceExists(command.getIncidenceType());

        final Incidence incidence = new Incidence(
                new IncidenceId(),
                new InsuranceId(command.getInsuranceId()),
                new CoverageIncidence(
                        new CoverageIncidenceId(command.getIncidenceType())
                ),
                new IncidenceAmount(command.getAmount(), command.getCurrency()),
                statusCalculatorStrategy.calculateStatus(
                        new InsuranceId(command.getInsuranceId()), new CoverageIncidenceId(command.getIncidenceType())),
                command.getDescription()
        );

        incidenceRepository.save(incidence);
    }

    private void ensureInsuranceExists(final String id) {
        final Insurance insurance = insuranceRepository.findOne(new InsuranceId(id));
        if (insurance == null) throw new IllegalArgumentException("Incidence insurance must exist");
    }

    private void ensureCoverageIncidenceExists(final String id) {
        final CoverageIncidence coverageIncidence = coverageIncidenceRepository.findOne(new CoverageIncidenceId(id));
        if (coverageIncidence == null) throw new IllegalArgumentException("Incidence type must exist");
    }

}
