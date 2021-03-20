package es.urjc.cloudapps.insurancecompany.clients.application.find;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.shared.domain.Address;

final class ClientFinderMapper {

    private ClientFinderMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ClientFinderResponse clientToClientFinderResponse(final Client client) {

        final ClientFinderResponse.Builder builder = ClientFinderResponse.builder()
                .id(client.getIdAsString())
                .name(client.getName())
                .surname(client.getSurname());

        if (client.getAddress() != null) {

            final Address address = client.getAddress();

            builder.country(address.getCountry())
                    .city(address.getCity())
                    .postalCode(address.getPostalCode())
                    .street(address.getStreet())
                    .number(address.getNumber());
        }

        return builder.build();
    }

}
