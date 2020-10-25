package es.urjc.cloudapps.insurancecompany.clients.application.create;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateClientCommand {

    private String name;

    private String surname;

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private String number;
}
