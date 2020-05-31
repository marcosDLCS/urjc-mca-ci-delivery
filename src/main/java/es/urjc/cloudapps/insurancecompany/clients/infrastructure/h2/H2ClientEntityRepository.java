package es.urjc.cloudapps.insurancecompany.clients.infrastructure.h2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface H2ClientEntityRepository extends JpaRepository<ClientEntity, String> {
    // H2ClientEntityRepository
}
