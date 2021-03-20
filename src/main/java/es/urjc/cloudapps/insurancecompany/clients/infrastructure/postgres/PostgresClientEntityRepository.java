package es.urjc.cloudapps.insurancecompany.clients.infrastructure.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresClientEntityRepository extends JpaRepository<ClientEntity, String> {
    // PostgresClientEntityRepository
}
