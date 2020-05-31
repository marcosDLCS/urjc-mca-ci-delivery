package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface H2CoverageEntityRepository extends JpaRepository<CoverageEntity, String> {
    // H2CoverageEntityRepository
}
