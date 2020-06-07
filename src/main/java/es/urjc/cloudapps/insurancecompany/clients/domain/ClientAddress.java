package es.urjc.cloudapps.insurancecompany.clients.domain;

import es.urjc.cloudapps.insurancecompany.shared.domain.Address;

public final class ClientAddress extends Address {

    public ClientAddress(final String country, final String city, final String postalCode, final String street,
                         final String number) {

        super(country, city, postalCode, street, number);
    }
}
