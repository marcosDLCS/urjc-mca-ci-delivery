package es.urjc.cloudapps.insurancecompany.integration;

import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientDTO;
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
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.with;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientIntegrationTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @LocalServerPort
    private int port;

    @BeforeAll
    void setUp() {
        RestAssured.port = this.port;
    }

    @Test
    @DisplayName("Client flow: create, get all and get by id")
    void create_client_flow() throws JsonProcessingException {

        final String INT_TESTS_CLIENTS = "### --> Integration Test: Clients. {} ";

        // Create client
        final ClientDTO initialClient = getRandomClient();

        saveClient(initialClient);
        log.info(INT_TESTS_CLIENTS, "...Saved client");

        // Get all clients
        final List<ClientDTO> response = getAllClients();
        log.info(INT_TESTS_CLIENTS, "...Clients from DB (find all) ... " + response.toString());

        // Ensure is client present in List
        final Optional<ClientDTO> clientFromResponse = response.stream()
                .filter(x -> x.getName().equals(initialClient.getName())).findFirst();

        assertThat(clientFromResponse).isPresent();

        // Ensure client is found by id
        final ClientDTO clientFromFindOne = getClientById(clientFromResponse.get().getId());
        log.info(INT_TESTS_CLIENTS, "...Client from DB (find one) ... " + clientFromFindOne);

        assertThat(clientFromFindOne).isNotNull();
        assertThat(clientFromFindOne.getName()).isEqualTo(initialClient.getName());
    }


    private ClientDTO getClientById(final String clientId) {
        return get("/clients/" + clientId).then().statusCode(200).and().extract().body().as(ClientDTO.class);
    }

    private void saveClient(final ClientDTO client) throws JsonProcessingException {
        with().body(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .request("POST", "/clients")
                .then()
                .statusCode(202);
    }

    private List<ClientDTO> getAllClients() {
        return Arrays.asList(get("/clients").then().statusCode(200).and().extract().body().as(ClientDTO[].class));
    }

}
