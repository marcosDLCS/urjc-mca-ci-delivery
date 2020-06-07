package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class InsuranceDTO {

    private String id;

    private String clientId;

    private HouseDTO house;

    private Set<String> coverages;

}
