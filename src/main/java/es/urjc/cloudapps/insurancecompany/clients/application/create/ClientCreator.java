package es.urjc.cloudapps.insurancecompany.clients.application.create;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientAddress;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientCreator {

    private final ClientRepository clientRepository;

    public ClientCreator(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(final CreateClientCommand command) {

        final ClientAddress clientAddress = new ClientAddress(
                command.getCountry(),
                command.getCity(),
                command.getPostalCode(),
                command.getStreet(),
                command.getNumber()
        );

        final Client client = new Client(
                new ClientId(),
                command.getName(),
                command.getSurname(),
                clientAddress
        );

        clientRepository.save(client);
    }
}
