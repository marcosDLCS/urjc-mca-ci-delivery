package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http;

import es.urjc.cloudapps.insurancecompany.incidences.application.find.IncidenceFinder;
import es.urjc.cloudapps.insurancecompany.incidences.domain.Incidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.shared.IncidenceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IncidencesGetController {

    private final IncidenceFinder incidenceFinder;
    private final IncidenceMapper incidenceMapper;

    public IncidencesGetController(IncidenceFinder incidenceFinder) {
        this.incidenceFinder = incidenceFinder;
        this.incidenceMapper = Mappers.getMapper(IncidenceMapper.class);
    }

    @GetMapping(path = "/incidences")
    public ResponseEntity<List<IncidenceDTO>> getAllIncidences() {

        List<Incidence> insurances = incidenceFinder.findAll();

        final List<IncidenceDTO> dto = insurances.stream()
                .map(incidenceMapper::incidenceToIncidenceDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/incidences/{id}")
    public ResponseEntity getIncidenceById(@PathVariable final String id) {

        final Incidence incidence = incidenceFinder.findOne(new IncidenceId(id));

        if (incidence != null) {
            final IncidenceDTO dto = incidenceMapper.incidenceToIncidenceDTO(incidence);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Incidence not found", HttpStatus.NOT_FOUND);
        }
    }


}
