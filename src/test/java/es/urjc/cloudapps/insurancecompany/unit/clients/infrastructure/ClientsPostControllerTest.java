package es.urjc.cloudapps.insurancecompany.unit.clients.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.urjc.cloudapps.insurancecompany.clients.application.create.ClientCreator;
import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientDTO;
import es.urjc.cloudapps.insurancecompany.clients.infrastructure.http.ClientsPostController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientsPostController.class)
@ExtendWith(MockitoExtension.class)
class ClientsPostControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientCreator clientCreator;

    @Test
    @DisplayName("Ensure status 202 ACCEPTED when invoke client create command")
    void ensure_controller_should_return_ok_when_receive_client_list() throws Exception {

        final ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("random-name");
        clientDTO.setSurname("random-surname");
        clientDTO.setCountry("random-country");
        clientDTO.setCity("random-city");
        clientDTO.setPostalCode("random-postsal-code");
        clientDTO.setNumber("random-number");

        doNothing().when(clientCreator).create(any());

        this.mockMvc.perform(post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(status().isAccepted());
    }

}