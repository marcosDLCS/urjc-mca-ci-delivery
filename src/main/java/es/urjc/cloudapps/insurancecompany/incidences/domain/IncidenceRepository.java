package es.urjc.cloudapps.insurancecompany.incidences.domain;

import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;

import java.util.List;

public interface IncidenceRepository {

    List<Incidence> findAll();

    Incidence findOne(IncidenceId id);

    List<Incidence> findByInsuranceId(InsuranceId insuranceId);

    void save(Incidence incidence);
}
