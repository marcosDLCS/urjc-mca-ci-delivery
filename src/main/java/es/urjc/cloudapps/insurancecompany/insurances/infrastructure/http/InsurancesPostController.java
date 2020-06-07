package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http;

import es.urjc.cloudapps.insurancecompany.insurances.application.create.CreateInsuranceCommand;
import es.urjc.cloudapps.insurancecompany.insurances.application.create.InsuranceCreator;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.shared.InsuranceMapper;
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
public class InsurancesPostController {

    private final InsuranceMapper insuranceMapper;
    private final InsuranceCreator insuranceCreator;


    public InsurancesPostController(InsuranceCreator insuranceCreator) {
        this.insuranceCreator = insuranceCreator;
        this.insuranceMapper = Mappers.getMapper(InsuranceMapper.class);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/insurances", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> newPost(@RequestBody InsuranceDTO dto) {

        final CreateInsuranceCommand command = insuranceMapper.insuranceDtoToInsuranceCommand(dto);
        insuranceCreator.create(command);
        return new ResponseEntity<>("Insurance created", HttpStatus.ACCEPTED);
    }

}
