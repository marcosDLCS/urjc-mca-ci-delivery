package es.urjc.cloudapps.insurancecompany.unit.insurances.shared;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidence;
import es.urjc.cloudapps.insurancecompany.insurances.application.find.InsuranceFinderResponse;
import es.urjc.cloudapps.insurancecompany.insurances.domain.*;
import es.urjc.cloudapps.insurancecompany.unit.clients.shared.ClientTestDataFactory;
import es.urjc.cloudapps.insurancecompany.unit.incidences.shared.IncidenceTestDataFactory;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public final class InsuranceTestDataFactory {

    private InsuranceTestDataFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static InsuranceId getValidInsuranceId() {
        return new InsuranceId(UUID.randomUUID().toString());
    }

    public static Set<CoverageIncidence> getValidCoverageIncidences() {
        return Set.of(IncidenceTestDataFactory.getValidCoverageIncidence());
    }

    public static HouseRegistry getValidHouseRegistry() {
        return new HouseRegistry("random-registry");
    }

    public static HouseAddress getValidHouseAddress() {
        return new HouseAddress("random-country", "random-city", "random-postal-code",
                "random-street", "random-number");
    }

    public static House getValidHouse() {
        return new House(getValidHouseRegistry(), getValidHouseAddress());
    }

    public static Set<Coverage> geValidCoverages() {
        return Set.of(new Coverage("random-coverage", getValidCoverageIncidences()));
    }

    public static Insurance getValidInsurance() {
        return new Insurance(getValidInsuranceId(), ClientTestDataFactory.getValidClientId(), getValidHouse(),
                geValidCoverages());
    }

    public static InsuranceFinderResponse getValidInsuranceFinderResponse() {
        return fromInsuranceToInsuranceResponse(getValidInsurance());
    }

    private static InsuranceFinderResponse fromInsuranceToInsuranceResponse(final Insurance insurance) {
        final var builder = InsuranceFinderResponse.builder()
                .id(insurance.getId() != null ? insurance.getId().getId() : null)
                .clientId(insurance.getClientId() != null ? insurance.getClientId().getId() : null);

        final var house = insurance.getHouse();
        HouseAddress houseAddress = null;

        if (house != null) {
            builder.registry(house.getRegistry() != null ? house.getRegistry().getRegistry() : null);
            houseAddress = house.getAddress();
        }

        if (houseAddress != null) {
            builder.country(houseAddress.getCountry()).city(houseAddress.getCity())
                    .postalCode(houseAddress.getPostalCode()).street(houseAddress.getStreet())
                    .number(houseAddress.getNumber());
        }

        builder.coverages(insurance.getCoverages().stream().map(Coverage::getName).collect(Collectors.toSet()));

        return builder.build();
    }

}
