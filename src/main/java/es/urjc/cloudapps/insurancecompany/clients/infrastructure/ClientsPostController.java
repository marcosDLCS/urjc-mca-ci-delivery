package es.urjc.cloudapps.insurancecompany.clients.infrastructure;

import es.urjc.cloudapps.insurancecompany.clients.application.create.ClientCreator;
import es.urjc.cloudapps.insurancecompany.clients.application.create.CreateClientCommand;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientsPostController {

    private final ClientMapper clientMapper;
    private final ClientCreator clientCreator;


    public ClientsPostController(ClientCreator clientCreator) {
        this.clientCreator = clientCreator;
        this.clientMapper = Mappers.getMapper(ClientMapper.class);
    }

    @PostMapping(path = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> newPost(@RequestBody ClientDTO dto) {

        final CreateClientCommand command = clientMapper.clientDtoToClientCommand(dto);
        clientCreator.create(command);
        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }

}
