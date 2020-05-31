package es.urjc.cloudapps.insurancecompany.clients.domain;

import es.urjc.cloudapps.insurancecompany.shared.domain.Uuid;

public class ClientId extends Uuid {

    public ClientId(String id) {
        super(id);
    }

    public ClientId() {
        super();
    }
}
