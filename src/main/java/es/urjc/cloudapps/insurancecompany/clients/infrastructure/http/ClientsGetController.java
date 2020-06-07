package es.urjc.cloudapps.insurancecompany.clients.infrastructure.http;

import es.urjc.cloudapps.insurancecompany.clients.application.find.ClientFinder;
import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.infrastructure.shared.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientsGetController {

    private final ClientMapper clientMapper;
    private final ClientFinder clientFinder;

    public ClientsGetController(final ClientFinder clientFinder) {
        this.clientFinder = clientFinder;
        this.clientMapper = Mappers.getMapper(ClientMapper.class);
    }

    @GetMapping(path = "/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {

        final List<Client> clients = clientFinder.findAll();
        final List<ClientDTO> dto = clients.stream()
                .map(clientMapper::clientToClientDto).collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/clients/{id}")
    public ResponseEntity getClientById(@PathVariable final String id) {

        final Client client = clientFinder.findOne(new ClientId(id));

        if (client != null) {
            return new ResponseEntity<>(clientMapper.clientToClientDto(client), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
    }

}
