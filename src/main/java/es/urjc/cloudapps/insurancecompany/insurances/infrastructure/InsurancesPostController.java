package es.urjc.cloudapps.insurancecompany.insurances.infrastructure;

import es.urjc.cloudapps.insurancecompany.insurances.application.create.CreateInsuranceCommand;
import es.urjc.cloudapps.insurancecompany.insurances.application.create.InsuranceCreator;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsurancesPostController {

    private final InsuranceMapper insuranceMapper;
    private final InsuranceCreator insuranceCreator;


    public InsurancesPostController(InsuranceCreator insuranceCreator) {
        this.insuranceCreator = insuranceCreator;
        this.insuranceMapper = Mappers.getMapper(InsuranceMapper.class);
    }

    @PostMapping(path = "/insurances", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> newPost(@RequestBody InsuranceDTO dto) {

        final CreateInsuranceCommand command = insuranceMapper.insuranceDtoToInsuranceCommand(dto);
        insuranceCreator.create(command);
        return new ResponseEntity<>("Insurance created", HttpStatus.CREATED);
    }

}
