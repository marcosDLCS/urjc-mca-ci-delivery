package es.urjc.cloudapps.insurancecompany.unit.incidences.infrastructure;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import es.urjc.cloudapps.insurancecompany.incidences.application.find.IncidenceFinder;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http.IncidencesGetController;
import es.urjc.cloudapps.insurancecompany.unit.incidences.shared.IncidenceTestDataFactory;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(IncidencesGetController.class)
@ExtendWith(MockitoExtension.class)
class IncidencesGetControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockitoBean private IncidenceFinder incidenceFinder;

  @Test
  @DisplayName("Ensure status 200 OK when incidence list is found")
  void ensure_controller_should_return_ok_when_receive_incidence_list() throws Exception {

    when(incidenceFinder.findAll())
        .thenReturn(List.of(IncidenceTestDataFactory.getValidIncidenceFinderResponse()));
    this.mockMvc.perform(get("/incidences")).andExpect(status().isOk());
  }

  @Test
  @DisplayName("Ensure status 200 OK when incidence is found")
  void ensure_controller_should_return_ok_when_receive_a_single_incidence() throws Exception {

    final String incidenceId = UUID.randomUUID().toString();

    when(incidenceFinder.findOne(any()))
        .thenReturn(IncidenceTestDataFactory.getValidIncidenceFinderResponse());
    this.mockMvc.perform(get("/incidences/" + incidenceId)).andExpect(status().isOk());
  }

  @Test
  @DisplayName("Ensure status 404 NOT_FOUND when incidence is not found")
  void ensure_controller_should_return_ok_when_not_receive_any_incidence() throws Exception {

    final String incidenceId = UUID.randomUUID().toString();

    when(incidenceFinder.findOne(any())).thenReturn(null);
    this.mockMvc.perform(get("/incidences/" + incidenceId)).andExpect(status().isNotFound());
  }
}
