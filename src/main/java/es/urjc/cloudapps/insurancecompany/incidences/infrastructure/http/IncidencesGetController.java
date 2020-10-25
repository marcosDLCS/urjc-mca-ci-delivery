package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http;

import es.urjc.cloudapps.insurancecompany.incidences.application.find.IncidenceFinder;
import es.urjc.cloudapps.insurancecompany.incidences.application.find.IncidenceFinderResponse;
import es.urjc.cloudapps.insurancecompany.incidences.shared.IncidenceMapper;
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

    public IncidencesGetController(final IncidenceFinder incidenceFinder) {
        this.incidenceFinder = incidenceFinder;
        this.incidenceMapper = Mappers.getMapper(IncidenceMapper.class);
    }

    @GetMapping(path = "/incidences")
    public ResponseEntity<List<IncidenceDto>> getAllIncidences() {

        final List<IncidenceFinderResponse> incidences = incidenceFinder.findAll();

        final List<IncidenceDto> dto = incidences.stream()
                .map(incidenceMapper::incidenceFinderResponseToIncidenceDto).collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/incidences/{id}")
    public ResponseEntity getIncidenceById(@PathVariable final String id) {

        final IncidenceFinderResponse incidence = incidenceFinder.findOne(id);

        if (incidence != null) {
            final IncidenceDto dto = incidenceMapper.incidenceFinderResponseToIncidenceDto(incidence);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Incidence not found", HttpStatus.NOT_FOUND);
        }
    }
}
