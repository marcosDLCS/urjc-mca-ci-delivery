package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCoverageIncidenceEntityRepository extends JpaRepository<CoverageIncidenceEntity, String> {
    // PostgresCoverageIncidenceEntityRepository
}
