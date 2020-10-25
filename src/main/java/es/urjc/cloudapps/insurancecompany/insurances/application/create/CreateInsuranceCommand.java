package es.urjc.cloudapps.insurancecompany.insurances.application.create;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class CreateInsuranceCommand {

    private String clientId;

    private String houseRegistry;

    private String houseCountry;

    private String houseCity;

    private String housePostalCode;

    private String houseStreet;

    private String houseNumber;

    private Set<String> coverages;
}
