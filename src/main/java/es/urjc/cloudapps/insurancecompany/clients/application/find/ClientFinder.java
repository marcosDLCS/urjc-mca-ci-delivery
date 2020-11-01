package es.urjc.cloudapps.insurancecompany.clients.application.find;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientFinder {

    private final ClientRepository clientRepository;

    public ClientFinder(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientFinderResponse> findAll() {
        final List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::fromClientToClientResponse).collect(Collectors.toList());
    }

    public ClientFinderResponse findOne(final String id) {
        final Client client = clientRepository.findOne(new ClientId(id));
        return fromClientToClientResponse(client);
    }

    private ClientFinderResponse fromClientToClientResponse(final Client client) {

        final ClientFinderResponse.Builder builder = ClientFinderResponse.builder()
                .id(client.getId().getId())
                .name(client.getName())
                .surname(client.getSurname());

        if (client.getAddress() != null) {
            builder.country(client.getAddress().getCountry())
                    .city(client.getAddress().getCity())
                    .postalCode(client.getAddress().getPostalCode())
                    .street(client.getAddress().getStreet())
                    .number(client.getAddress().getNumber());
        }
        return builder.build();
    }
}
