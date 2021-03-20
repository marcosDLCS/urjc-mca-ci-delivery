package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCoverageEntityRepository extends JpaRepository<CoverageEntity, String> {
    // PostgresCoverageEntityRepository
}
