package es.urjc.cloudapps.insurancecompany.insurances.domain;

import es.urjc.cloudapps.insurancecompany.shared.domain.Address;

public final class HouseAddress extends Address {

    public HouseAddress(final String country, final String city, final String postalCode, final String street,
                        final String number) {

        super(country, city, postalCode, street, number);
    }
}
