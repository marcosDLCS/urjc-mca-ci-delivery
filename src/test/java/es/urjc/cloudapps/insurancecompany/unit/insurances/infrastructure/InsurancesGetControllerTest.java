package es.urjc.cloudapps.insurancecompany.unit.insurances.infrastructure;

import es.urjc.cloudapps.insurancecompany.insurances.application.find.InsuranceFinder;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsurancesGetController;
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

import static es.urjc.cloudapps.insurancecompany.unit.insurances.shared.InsuranceTestDataFactory.getValidInsuranceFinderResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InsurancesGetController.class)
@ExtendWith(MockitoExtension.class)
class InsurancesGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InsuranceFinder insuranceFinder;

    @Test
    @DisplayName("Ensure status 200 OK when insurance list is found")
    void ensure_controller_should_return_ok_when_receive_insurance_list() throws Exception {

        when(insuranceFinder.findAll()).thenReturn(List.of(getValidInsuranceFinderResponse()));
        this.mockMvc.perform(get("/insurances")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Ensure status 200 OK when insurance is found")
    void ensure_controller_should_return_ok_when_receive_a_single_insurance() throws Exception {

        final String incidenceId = UUID.randomUUID().toString();

        when(insuranceFinder.findOne(any())).thenReturn(getValidInsuranceFinderResponse());
        this.mockMvc.perform(get("/insurances/" + incidenceId)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Ensure status 404 NOT_FOUND when insurance is not found")
    void ensure_controller_should_return_ok_when_not_receive_any_insurance() throws Exception {

        final String incidenceId = UUID.randomUUID().toString();

        when(insuranceFinder.findOne(any())).thenReturn(null);
        this.mockMvc.perform(get("/insurances/" + incidenceId)).andExpect(status().isNotFound());
    }

}