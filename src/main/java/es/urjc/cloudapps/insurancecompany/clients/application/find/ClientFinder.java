package es.urjc.cloudapps.insurancecompany.clients.application.find;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientFinder {

    private final ClientRepository clientRepository;

    public ClientFinder(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findOne(final ClientId id) {
        return clientRepository.findOne(id);
    }
}
