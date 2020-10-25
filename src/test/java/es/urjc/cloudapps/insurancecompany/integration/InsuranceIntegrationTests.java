package es.urjc.cloudapps.insurancecompany.integration;

import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientDto;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsuranceDto;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static es.urjc.cloudapps.insurancecompany.integration.IntegrationTestDataFactory.getRandomClient;
import static es.urjc.cloudapps.insurancecompany.integration.IntegrationTestDataFactory.getRandomInsurance;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.with;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InsuranceIntegrationTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @LocalServerPort
    private int port;

    @BeforeAll
    void setUp() {
        RestAssured.port = this.port;
    }

    @Test
    @DisplayName("Insurance flow: create, get all and get by id")
    void create_insurance_flow() throws JsonProcessingException {

        final String INT_TESTS_CLIENTS = "### --> Integration Test: Insurances. {} ";

        final InsuranceDto initialInsurance = getRandomInsurance(getClient().getId());

        saveInsurance(initialInsurance);
        log.info(INT_TESTS_CLIENTS, "...Saved insurance");

        // Get all insurances
        final List<InsuranceDto> response = getAllInsurances();
        log.info(INT_TESTS_CLIENTS, "...Insurances from DB (find all) ... " + response.toString());

        // Ensure is insurance present in List
        final Optional<InsuranceDto> insuranceFromResponse = response.stream()
                .filter(x -> x.getClientId().equals(initialInsurance.getClientId())).findFirst();

        assertThat(insuranceFromResponse).isPresent();

        // Ensure insurance is found by id
        final InsuranceDto insuranceFromFindOne = getInsuranceById(insuranceFromResponse.get().getId());
        log.info(INT_TESTS_CLIENTS, "...Insurance from DB (find one) ... " + insuranceFromFindOne);

        assertThat(insuranceFromFindOne).isNotNull();
        assertThat(insuranceFromFindOne.getClientId()).isEqualTo(initialInsurance.getClientId());
    }


    private InsuranceDto getInsuranceById(final String insuranceId) {
        return get("/insurances/" + insuranceId).then().statusCode(200).and().extract().body().as(InsuranceDto.class);
    }

    private void saveInsurance(final InsuranceDto insurance) throws JsonProcessingException {
        with().body(objectMapper.writeValueAsString(insurance))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .request("POST", "/insurances")
                .then()
                .statusCode(202);
    }

    private List<InsuranceDto> getAllInsurances() {
        return Arrays.asList(get("/insurances").then().statusCode(200).and().extract().body().as(InsuranceDto[].class));
    }

    private ClientDto getClient() throws JsonProcessingException {

        final ClientDto randomClient = getRandomClient();

        with().body(objectMapper.writeValueAsString(randomClient))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .request("POST", "/clients")
                .then()
                .statusCode(202);

        return Arrays.asList(
                get("/clients").then().statusCode(200).and().extract().body().as(ClientDto[].class))
                .get(0);
    }

}
