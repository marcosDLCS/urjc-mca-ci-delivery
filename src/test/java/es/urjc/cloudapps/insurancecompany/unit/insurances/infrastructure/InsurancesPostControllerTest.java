package es.urjc.cloudapps.insurancecompany.unit.insurances.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.urjc.cloudapps.insurancecompany.insurances.application.create.InsuranceCreator;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.HouseDTO;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsuranceDTO;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsurancesPostController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InsurancesPostController.class)
@ExtendWith(MockitoExtension.class)
class InsurancesPostControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InsuranceCreator insuranceCreator;

    @Test
    @DisplayName("Ensure status 202 ACCEPTED when invoke incidence create command")
    void ensure_controller_should_return_ok_when_receive_client_list() throws Exception {

        final HouseDTO houseDTO = new HouseDTO();
        houseDTO.setRegistry("random-registry");
        houseDTO.setCountry("random-country");
        houseDTO.setCity("random-city");
        houseDTO.setPostalCode("random-postal-code");
        houseDTO.setStreet("random-street");
        houseDTO.setNumber("random-number");

        final InsuranceDTO insuranceDTO = new InsuranceDTO();
        insuranceDTO.setClientId(UUID.randomUUID().toString());
        insuranceDTO.setHouse(houseDTO);
        insuranceDTO.setCoverages(Set.of("WINDOWS_COVERAGE", "ELECTRONIC_DEVICES_COVERAGE"));

        doNothing().when(insuranceCreator).create(any());

        this.mockMvc.perform(post("/insurances")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(insuranceDTO)))
                .andExpect(status().isAccepted());
    }

}