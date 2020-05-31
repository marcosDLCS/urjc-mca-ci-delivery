package es.urjc.cloudapps.insurancecompany.clients.infrastructure.h2;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientAddress;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import es.urjc.cloudapps.insurancecompany.clients.infrastructure.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class H2ClientRepository implements ClientRepository {

    private final H2ClientEntityRepository h2ClientEntityRepository;
    private final ClientMapper clientMapper;

    public H2ClientRepository(H2ClientEntityRepository h2ClientEntityRepository) {
        this.h2ClientEntityRepository = h2ClientEntityRepository;
        this.clientMapper = Mappers.getMapper(ClientMapper.class);
    }

    @Override
    public List<Client> findAll() {

        final List<ClientEntity> clients = h2ClientEntityRepository.findAll();
        return clients.stream().map(this::clientEntityToClient).collect(Collectors.toList());
    }

    @Override
    public Client findOne(ClientId id) {

        final Optional<ClientEntity> client = h2ClientEntityRepository.findById(id.getId());
        return client.map(this::clientEntityToClient).orElse(null);
    }

    @Override
    public void save(Client client) {

        final ClientEntity clientEntity = clientMapper.clientToClientEntity(client);
        h2ClientEntityRepository.save(clientEntity);
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
