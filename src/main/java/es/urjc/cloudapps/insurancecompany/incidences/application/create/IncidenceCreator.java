package es.urjc.cloudapps.insurancecompany.incidences.application.create;

import es.urjc.cloudapps.insurancecompany.incidences.domain.*;
import es.urjc.cloudapps.insurancecompany.insurances.domain.Insurance;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class IncidenceCreator {

    private final IncidenceRepository incidenceRepository;
    private final InsuranceRepository insuranceRepository;
    private final CoverageIncidenceRepository coverageIncidenceRepository;
    private final IncidenceStatusCalculatorStrategy statusCalculatorStrategy;

    public IncidenceCreator(final IncidenceRepository incidenceRepository,
                            final InsuranceRepository insuranceRepository,
                            final CoverageIncidenceRepository coverageIncidenceRepository,
                            final IncidenceStatusCalculatorStrategy statusCalculatorStrategy) {

        this.incidenceRepository = incidenceRepository;
        this.insuranceRepository = insuranceRepository;
        this.coverageIncidenceRepository = coverageIncidenceRepository;
        this.statusCalculatorStrategy = statusCalculatorStrategy;
    }

    public void create(final CreateIncidenceCommand command) {

        // TODO: Use non-framework utils to ensure domain properties

        Assert.isTrue(insuranceExists(command.getInsuranceId()), "Incidence insurance must exist");
        Assert.isTrue(coverageIncidenceExists(command.getIncidenceType()), "Incidence type must exist");

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

    private boolean insuranceExists(final String id) {

        final Insurance insurance = insuranceRepository.findOne(new InsuranceId(id));
        return insurance != null;
    }

    private boolean coverageIncidenceExists(final String id) {

        final CoverageIncidence coverageIncidence = coverageIncidenceRepository.findOne(new CoverageIncidenceId(id));
        return coverageIncidence != null;
    }

}
