package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.h2;

import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface H2IncidenceEntityRepository extends JpaRepository<IncidenceEntity, String> {
    // H2IncidenceEntityRepository

    List<IncidenceEntity> findByInsurance(InsuranceEntity insurance);
}
