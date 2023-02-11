package es.urjc.cloudapps.insurancecompany.integration;

import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientDto;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http.IncidenceDto;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsuranceDto;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static es.urjc.cloudapps.insurancecompany.integration.IntegrationTestDataFactory.*;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.with;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IncidenceIntegrationTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @LocalServerPort
    private int port;

    @BeforeAll
    void setUp() {
        RestAssured.port = this.port;
    }

    @Test
    @DisplayName("Incidence flow: create, get all and get by id")
    void create_incidence_flow() throws JsonProcessingException {

        final String INT_TESTS_CLIENTS = "### --> Integration Test: Incidences. {} ";

        // Create incidence
        final IncidenceDto initialIncidence = getRandomIncidence(getInsurance().getId());

        saveIncidence(initialIncidence);
        log.info(INT_TESTS_CLIENTS, "...Saved incidence");

        // Get all incidences
        final List<IncidenceDto> response = getAllIncidences();
        log.info(INT_TESTS_CLIENTS, "...Incidences from DB (find all) ... " + response.toString());

        // Ensure is incidence present in List
        final Optional<IncidenceDto> incidenceFromResponse = response.stream()
                .filter(x -> x.getInsuranceId().equals(initialIncidence.getInsuranceId())).findFirst();

        assertThat(incidenceFromResponse).isPresent();

        // Ensure incidence is found by id
        final IncidenceDto incidenceFromFindOne = getIncidenceById(incidenceFromResponse.get().getId());
        log.info(INT_TESTS_CLIENTS, "...Incidence from DB (find one) ... " + incidenceFromFindOne);

        assertThat(incidenceFromFindOne).isNotNull();
        assertThat(incidenceFromFindOne.getInsuranceId()).isEqualTo(initialIncidence.getInsuranceId());
    }


    private IncidenceDto getIncidenceById(final String incidenceId) {
        return get("/incidences/" + incidenceId).then().statusCode(200).and().extract().body().as(IncidenceDto.class);
    }

    private void saveIncidence(final IncidenceDto incidence) throws JsonProcessingException {
        with().body(objectMapper.writeValueAsString(incidence))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .request("POST", "/incidences")
                .then()
                .statusCode(202);
    }

    private List<IncidenceDto> getAllIncidences() {
        return Arrays.asList(get("/incidences").then().statusCode(200).and().extract().body().as(IncidenceDto[].class));
    }

    private InsuranceDto getInsurance() throws JsonProcessingException {

        final ClientDto randomClient = getRandomClient();

        with().body(objectMapper.writeValueAsString(randomClient))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .request("POST", "/clients")
                .then()
                .statusCode(202);

        final ClientDto clientFromDb = Arrays.asList(
                        get("/clients").then().statusCode(200).and().extract().body().as(ClientDto[].class))
                .get(0);

        with().body(objectMapper.writeValueAsString(getRandomInsurance(clientFromDb.getId())))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .request("POST", "/insurances")
                .then()
                .statusCode(202);

        return Arrays.asList(
                        get("/insurances").then().statusCode(200).and().extract().body().as(InsuranceDto[].class))
                .get(0);
    }

}
