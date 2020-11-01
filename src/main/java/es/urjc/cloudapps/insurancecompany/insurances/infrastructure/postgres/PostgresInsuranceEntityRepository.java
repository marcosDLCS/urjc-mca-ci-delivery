package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresInsuranceEntityRepository extends JpaRepository<InsuranceEntity, String> {
    // PostgresInsuranceEntityRepository

    InsuranceEntity findByHouseRegistry(String registry);
}
