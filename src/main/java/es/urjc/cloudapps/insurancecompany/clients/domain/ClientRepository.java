package es.urjc.cloudapps.insurancecompany.clients.domain;

import java.util.List;

public interface ClientRepository {

    List<Client> findAll();

    Client findOne(ClientId id);

    void save(Client client);
}
