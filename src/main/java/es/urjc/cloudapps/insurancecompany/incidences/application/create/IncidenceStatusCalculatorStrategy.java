package es.urjc.cloudapps.insurancecompany.incidences.application.create;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceStatus;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;

public interface IncidenceStatusCalculatorStrategy {

    IncidenceStatus calculateStatus(InsuranceId insuranceId, CoverageIncidenceId coverageIncidenceId);

}
