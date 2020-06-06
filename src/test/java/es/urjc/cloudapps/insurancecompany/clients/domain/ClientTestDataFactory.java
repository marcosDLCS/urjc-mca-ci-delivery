package es.urjc.cloudapps.insurancecompany.clients.domain;

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
}
