package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresInsuranceEntityRepository extends JpaRepository<InsuranceEntity, String> {
    // H2InsuranceEntityRepository

    InsuranceEntity findByHouseRegistry(String registry);
}
