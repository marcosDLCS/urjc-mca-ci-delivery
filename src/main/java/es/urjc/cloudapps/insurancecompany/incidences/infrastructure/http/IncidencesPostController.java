package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http;

import es.urjc.cloudapps.insurancecompany.incidences.application.create.CreateIncidenceCommand;
import es.urjc.cloudapps.insurancecompany.incidences.application.create.IncidenceCreator;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.shared.IncidenceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class IncidencesPostController {

    private final IncidenceMapper incidenceMapper;
    private final IncidenceCreator incidenceCreator;


    public IncidencesPostController(IncidenceCreator incidenceCreator) {
        this.incidenceCreator = incidenceCreator;
        this.incidenceMapper = Mappers.getMapper(IncidenceMapper.class);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/incidences", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> newPost(@RequestBody IncidenceDTO dto) {

        final CreateIncidenceCommand command = incidenceMapper.incidenceDTOtoIncidenceCommand(dto);
        incidenceCreator.create(command);
        return new ResponseEntity<>("Incidence created", HttpStatus.ACCEPTED);
    }

}
