package es.urjc.cloudapps.insurancecompany.unit.clients.shared;

import es.urjc.cloudapps.insurancecompany.clients.application.find.ClientFinderResponse;
import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientAddress;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;

import java.util.UUID;

public final class ClientTestDataFactory {

    private ClientTestDataFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
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

    public static ClientFinderResponse getValidClientFinderResponse() {
        final Client client = getValidClient();
        return fromClientToClientResponse(client);
    }

    private static ClientFinderResponse fromClientToClientResponse(final Client client) {
        final var builder = ClientFinderResponse.builder()
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
