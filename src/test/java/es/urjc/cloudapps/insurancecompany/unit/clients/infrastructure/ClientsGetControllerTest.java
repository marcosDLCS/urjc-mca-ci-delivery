package es.urjc.cloudapps.insurancecompany.unit.clients.infrastructure;

import es.urjc.cloudapps.insurancecompany.clients.application.find.ClientFinder;
import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientsGetController;
import es.urjc.cloudapps.insurancecompany.unit.clients.shared.ClientTestDataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientsGetController.class)
@ExtendWith(MockitoExtension.class)
class ClientsGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientFinder clientFinder;

    @Test
    @DisplayName("Ensure status 200 OK when client list is found")
    void ensure_controller_should_return_ok_when_receive_client_list() throws Exception {

        when(clientFinder.findAll()).thenReturn(List.of(ClientTestDataFactory.getValidClient()));
        this.mockMvc.perform(get("/clients")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Ensure status 200 OK when client is found")
    void ensure_controller_should_return_ok_when_receive_a_single_client() throws Exception {

        final String clientId = UUID.randomUUID().toString();

        when(clientFinder.findOne(any())).thenReturn(ClientTestDataFactory.getValidClient());
        this.mockMvc.perform(get("/clients/" + clientId)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Ensure status 404 NOT_FOUND when client is not found")
    void ensure_controller_should_return_ok_when_not_receive_any_client() throws Exception {

        final String clientId = UUID.randomUUID().toString();

        when(clientFinder.findOne(any())).thenReturn(null);
        this.mockMvc.perform(get("/clients/" + clientId)).andExpect(status().isNotFound());
    }

}