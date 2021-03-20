package es.urjc.cloudapps.insurancecompany.incidences.domain;

public interface CoverageIncidenceRepository {

    CoverageIncidence findOne(CoverageIncidenceId id);
}
