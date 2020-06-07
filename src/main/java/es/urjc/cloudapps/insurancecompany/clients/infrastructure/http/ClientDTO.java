package es.urjc.cloudapps.insurancecompany.clients.infrastructure.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO {

    private String id;

    private String name;

    private String surname;

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private String number;

}
