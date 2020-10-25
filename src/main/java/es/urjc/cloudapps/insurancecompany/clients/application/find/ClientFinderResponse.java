package es.urjc.cloudapps.insurancecompany.clients.application.find;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class ClientFinderResponse {

    private final String id;

    private final String name;

    private final String surname;

    private final String country;

    private final String city;

    private final String postalCode;

    private final String street;

    private final String number;
}
