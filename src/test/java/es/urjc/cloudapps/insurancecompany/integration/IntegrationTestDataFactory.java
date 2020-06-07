package es.urjc.cloudapps.insurancecompany.integration;

import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientDTO;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceType;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http.IncidenceDTO;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.HouseDTO;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsuranceDTO;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public final class IntegrationTestDataFactory {

    private IntegrationTestDataFactory() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ClientDTO getRandomClient() {

        final ClientDTO randomClient = new ClientDTO();
        randomClient.setName(RandomStringUtils.randomAlphabetic(10));
        randomClient.setSurname("rdm-surname");
        randomClient.setCountry("rdm-country");
        randomClient.setCity("rdm-city");
        randomClient.setPostalCode("rdm-postsal-code");
        randomClient.setStreet("rdm-street");
        randomClient.setNumber("rdm-number");

        return randomClient;
    }

    public static InsuranceDTO getRandomInsurance(final String clientId) {

        final HouseDTO randomHouse = new HouseDTO();
        randomHouse.setRegistry(UUID.randomUUID().toString());
        randomHouse.setCountry("rdm-country");
        randomHouse.setCity("rdm-city");
        randomHouse.setPostalCode("rdm-postal-code");
        randomHouse.setStreet("rdm-street");
        randomHouse.setNumber("rdm-number");

        final InsuranceDTO randomInsurance = new InsuranceDTO();
        randomInsurance.setClientId(clientId);
        randomInsurance.setHouse(randomHouse);
        randomInsurance.setCoverages(Set.of("WINDOWS_COVERAGE", "ELECTRONIC_DEVICES_COVERAGE"));

        return randomInsurance;
    }

    public static IncidenceDTO getRandomIncidence(final String insuranceId) {

        final IncidenceDTO randomIncidence = new IncidenceDTO();
        randomIncidence.setInsuranceId(insuranceId);
        randomIncidence.setIncidenceType(IncidenceType.ACCIDENT.name());
        randomIncidence.setDescription("rdm-description");
        randomIncidence.setAmount(BigDecimal.TEN);
        randomIncidence.setCurrency("EUR");

        return randomIncidence;
    }
}
