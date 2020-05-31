package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface H2InsuranceEntityRepository extends JpaRepository<InsuranceEntity, String> {
    // H2InsuranceEntityRepository

    InsuranceEntity findByHouseRegistry(String registry);
}
