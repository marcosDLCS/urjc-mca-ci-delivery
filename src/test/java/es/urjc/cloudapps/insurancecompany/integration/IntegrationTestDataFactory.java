package es.urjc.cloudapps.insurancecompany.integration;

import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientDto;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceType;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http.IncidenceDto;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.HouseDTO;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsuranceDto;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public final class IntegrationTestDataFactory {

    private IntegrationTestDataFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ClientDto getRandomClient() {

        final ClientDto randomClient = new ClientDto();
        randomClient.setName(RandomStringUtils.randomAlphabetic(10));
        randomClient.setSurname("rdm-surname");
        randomClient.setCountry("rdm-country");
        randomClient.setCity("rdm-city");
        randomClient.setPostalCode("rdm-postsal-code");
        randomClient.setStreet("rdm-street");
        randomClient.setNumber("rdm-number");

        return randomClient;
    }

    public static InsuranceDto getRandomInsurance(final String clientId) {

        final HouseDTO randomHouse = new HouseDTO();
        randomHouse.setRegistry(UUID.randomUUID().toString());
        randomHouse.setCountry("rdm-country");
        randomHouse.setCity("rdm-city");
        randomHouse.setPostalCode("rdm-postal-code");
        randomHouse.setStreet("rdm-street");
        randomHouse.setNumber("rdm-number");

        final InsuranceDto randomInsurance = new InsuranceDto();
        randomInsurance.setClientId(clientId);
        randomInsurance.setHouse(randomHouse);
        randomInsurance.setCoverages(Set.of("WINDOWS_COVERAGE", "ELECTRONIC_DEVICES_COVERAGE"));

        return randomInsurance;
    }

    public static IncidenceDto getRandomIncidence(final String insuranceId) {

        final IncidenceDto randomIncidence = new IncidenceDto();
        randomIncidence.setInsuranceId(insuranceId);
        randomIncidence.setIncidenceType(IncidenceType.ACCIDENT.name());
        randomIncidence.setDescription("rdm-description");
        randomIncidence.setAmount(BigDecimal.TEN);
        randomIncidence.setCurrency("EUR");

        return randomIncidence;
    }
}
