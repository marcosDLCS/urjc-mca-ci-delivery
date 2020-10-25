package es.urjc.cloudapps.insurancecompany.clients.infrastructure.postgres;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientAddress;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import es.urjc.cloudapps.insurancecompany.clients.shared.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostgresClientRepository implements ClientRepository {

    private final PostgresClientEntityRepository postgresClientEntityRepository;
    private final ClientMapper clientMapper;

    public PostgresClientRepository(final PostgresClientEntityRepository postgresClientEntityRepository) {
        this.postgresClientEntityRepository = postgresClientEntityRepository;
        this.clientMapper = Mappers.getMapper(ClientMapper.class);
    }

    @Override
    public List<Client> findAll() {

        final List<ClientEntity> clients = postgresClientEntityRepository.findAll();
        return clients.stream().map(this::clientEntityToClient).collect(Collectors.toList());
    }

    @Override
    public Client findOne(ClientId id) {

        final Optional<ClientEntity> client = postgresClientEntityRepository.findById(id.getId());
        return client.map(this::clientEntityToClient).orElse(null);
    }

    @Override
    public void save(Client client) {

        final ClientEntity clientEntity = clientMapper.clientToClientEntity(client);
        postgresClientEntityRepository.save(clientEntity);
    }

    private Client clientEntityToClient(ClientEntity c) {

        ClientId clientId = new ClientId(c.getId());
        ClientAddress clientAddress = new ClientAddress(
                c.getCountry(),
                c.getCity(),
                c.getPostalCode(),
                c.getStreet(),
                c.getNumber());
        return new Client(clientId, c.getName(), c.getSurname(), clientAddress);
    }
}
