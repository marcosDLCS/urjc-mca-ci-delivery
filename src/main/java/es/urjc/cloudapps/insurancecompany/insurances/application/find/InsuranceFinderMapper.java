package es.urjc.cloudapps.insurancecompany.insurances.application.find;

import es.urjc.cloudapps.insurancecompany.insurances.domain.Coverage;
import es.urjc.cloudapps.insurancecompany.insurances.domain.HouseAddress;
import es.urjc.cloudapps.insurancecompany.insurances.domain.Insurance;

import java.util.stream.Collectors;

final class InsuranceFinderMapper {

    private InsuranceFinderMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static InsuranceFinderResponse insuranceToInsuranceFinderResponse(final Insurance insurance) {

        final var builder = InsuranceFinderResponse.builder()
                .id(insurance.getIdAsString())
                .clientId(insurance.getClientIdAsString());

        final var house = insurance.getHouse();
        HouseAddress houseAddress = null;

        if (house != null) {
            builder.registry(house.getRegistry() != null ? house.getRegistry().getRegistry() : null);
            houseAddress = house.getAddress();
        }

        if (houseAddress != null) {
            builder.country(houseAddress.getCountry())
                    .city(houseAddress.getCity())
                    .postalCode(houseAddress.getPostalCode())
                    .street(houseAddress.getStreet())
                    .number(houseAddress.getNumber());
        }

        builder.coverages(insurance.getCoverages().stream().map(Coverage::getName).collect(Collectors.toSet()));

        return builder.build();
    }
}
