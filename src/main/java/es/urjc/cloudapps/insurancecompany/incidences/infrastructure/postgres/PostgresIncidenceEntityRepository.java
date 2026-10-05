package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres;

import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres.InsuranceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresIncidenceEntityRepository extends JpaRepository<IncidenceEntity, String> {
  // PostgresIncidenceEntityRepository

  List<IncidenceEntity> findByInsurance(InsuranceEntity insurance);
}
