package es.urjc.cloudapps.insurancecompany.clients.infrastructure.http;

import es.urjc.cloudapps.insurancecompany.clients.application.create.ClientCreator;
import es.urjc.cloudapps.insurancecompany.clients.application.create.CreateClientCommand;
import es.urjc.cloudapps.insurancecompany.clients.shared.ClientMapper;
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
public class ClientsPostController {

    private final ClientMapper clientMapper;
    private final ClientCreator clientCreator;


    public ClientsPostController(ClientCreator clientCreator) {
        this.clientCreator = clientCreator;
        this.clientMapper = Mappers.getMapper(ClientMapper.class);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/clients", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> newPost(@RequestBody ClientDto dto) {

        final CreateClientCommand command = clientMapper.clientDtoToClientCommand(dto);
        clientCreator.create(command);
        return new ResponseEntity<>("Client created", HttpStatus.ACCEPTED);
    }

}
