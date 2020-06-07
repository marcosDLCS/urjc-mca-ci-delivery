package es.urjc.cloudapps.insurancecompany.unit.clients.shared;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientAddress;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;

import java.util.UUID;

public final class ClientTestDataFactory {

    private ClientTestDataFactory() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ClientId getValidClientId() {

        return new ClientId(UUID.randomUUID().toString());
    }

    public static ClientAddress getValidClientAddress() {

        return new ClientAddress("random-country", "random-city",
                "random-postal-code", "random-street", "random-number");
    }

    public static Client getValidClient() {
        return new Client(getValidClientId(), "random-name", "random-surname", getValidClientAddress());
    }
}
