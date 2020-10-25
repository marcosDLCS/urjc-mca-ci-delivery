package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http;

import es.urjc.cloudapps.insurancecompany.insurances.application.find.InsuranceFinder;
import es.urjc.cloudapps.insurancecompany.insurances.application.find.InsuranceFinderResponse;
import es.urjc.cloudapps.insurancecompany.insurances.shared.InsuranceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InsurancesGetController {

    private final InsuranceFinder insuranceFinder;
    private final InsuranceMapper insuranceMapper;

    public InsurancesGetController(final InsuranceFinder insuranceFinder) {
        this.insuranceFinder = insuranceFinder;
        this.insuranceMapper = Mappers.getMapper(InsuranceMapper.class);
    }

    @GetMapping(path = "/insurances")
    public ResponseEntity<List<InsuranceDto>> getAllInsurances() {

        final List<InsuranceFinderResponse> insurances = insuranceFinder.findAll();

        final List<InsuranceDto> dto = insurances.stream()
                .map(insuranceMapper::insuranceFinderResponseToInsuranceDto).collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/insurances/{id}")
    public ResponseEntity getInsuranceById(@PathVariable final String id) {

        final InsuranceFinderResponse insurance = insuranceFinder.findOne(id);

        if (insurance != null) {
            final InsuranceDto dto = insuranceMapper.insuranceFinderResponseToInsuranceDto(insurance);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Insurance not found", HttpStatus.NOT_FOUND);
        }
    }

}
