package es.urjc.cloudapps.insurancecompany.incidences.infrastructure;

import es.urjc.cloudapps.insurancecompany.incidences.application.create.CreateIncidenceCommand;
import es.urjc.cloudapps.insurancecompany.incidences.application.create.IncidenceCreator;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidencesPostController {

    private final IncidenceMapper incidenceMapper;
    private final IncidenceCreator incidenceCreator;


    public IncidencesPostController(IncidenceCreator incidenceCreator) {
        this.incidenceCreator = incidenceCreator;
        this.incidenceMapper = Mappers.getMapper(IncidenceMapper.class);
    }

    @PostMapping(path = "/incidences", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> newPost(@RequestBody IncidenceDTO dto) {

        final CreateIncidenceCommand command = incidenceMapper.incidenceDTOtoIncidenceCommand(dto);
        incidenceCreator.create(command);
        return new ResponseEntity<>("Incidence created", HttpStatus.CREATED);
    }

}
