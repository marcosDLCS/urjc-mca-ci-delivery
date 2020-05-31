package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.h2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface H2CoverageIncidenceEntityRepository extends JpaRepository<CoverageIncidenceEntity, String> {
    // H2CoverageIncidenceEntityRepository
}
