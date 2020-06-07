package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HouseDTO {

    private String registry;

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private String number;

}
