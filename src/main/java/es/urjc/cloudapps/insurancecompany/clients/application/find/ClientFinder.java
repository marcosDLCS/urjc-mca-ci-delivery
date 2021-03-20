package es.urjc.cloudapps.insurancecompany.clients.application.find;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static es.urjc.cloudapps.insurancecompany.clients.application.find.ClientFinderMapper.clientToClientFinderResponse;

@Service
public class ClientFinder {

    private final ClientRepository clientRepository;

    public ClientFinder(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientFinderResponse> findAll() {
        final List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientFinderMapper::clientToClientFinderResponse)
                .collect(Collectors.toList());
    }

    public ClientFinderResponse findOne(final String id) {
        final Client client = clientRepository.findOne(new ClientId(id));
        return clientToClientFinderResponse(client);
    }
}
