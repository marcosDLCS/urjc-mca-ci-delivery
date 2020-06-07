package es.urjc.cloudapps.insurancecompany.unit.incidences.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.urjc.cloudapps.insurancecompany.incidences.application.create.IncidenceCreator;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceType;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http.IncidenceDTO;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http.IncidencesPostController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IncidencesPostController.class)
@ExtendWith(MockitoExtension.class)
class IncidencesPostControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IncidenceCreator incidenceCreator;

    @Test
    @DisplayName("Ensure status 202 ACCEPTED when invoke incidence create command")
    void ensure_controller_should_return_ok_when_receive_client_list() throws Exception {

        final IncidenceDTO incidenceDTO = new IncidenceDTO();
        incidenceDTO.setInsuranceId(UUID.randomUUID().toString());
        incidenceDTO.setIncidenceType(IncidenceType.ACCIDENT.name());
        incidenceDTO.setDescription("random-description");
        incidenceDTO.setAmount(BigDecimal.TEN);
        incidenceDTO.setCurrency("EUR");

        doNothing().when(incidenceCreator).create(any());

        this.mockMvc.perform(post("/incidences")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incidenceDTO)))
                .andExpect(status().isAccepted());
    }

}