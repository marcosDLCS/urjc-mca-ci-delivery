package es.urjc.cloudapps.insurancecompany.insurances.domain;

import java.util.List;

public interface InsuranceRepository {

    List<Insurance> findAll();

    Insurance findOne(InsuranceId id);

    Insurance findByHouseRegistry(HouseRegistry registry);

    void save(Insurance client);
}
