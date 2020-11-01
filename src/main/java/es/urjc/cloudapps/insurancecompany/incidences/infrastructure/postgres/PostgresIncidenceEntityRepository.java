package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres;

import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostgresIncidenceEntityRepository extends JpaRepository<IncidenceEntity, String> {
    // PostgresIncidenceEntityRepository

    List<IncidenceEntity> findByInsurance(InsuranceEntity insurance);
}
