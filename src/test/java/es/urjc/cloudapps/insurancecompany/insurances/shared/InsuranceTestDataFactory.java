package es.urjc.cloudapps.insurancecompany.insurances.shared;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidence;
import es.urjc.cloudapps.insurancecompany.incidences.shared.IncidenceTestDataFactory;
import es.urjc.cloudapps.insurancecompany.insurances.domain.*;

import java.util.Set;
import java.util.UUID;

import static es.urjc.cloudapps.insurancecompany.clients.shared.ClientTestDataFactory.getValidClientId;

public final class InsuranceTestDataFactory {

    private InsuranceTestDataFactory() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
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
        return new Insurance(getValidInsuranceId(), getValidClientId(), getValidHouse(), geValidCoverages());
    }

}
