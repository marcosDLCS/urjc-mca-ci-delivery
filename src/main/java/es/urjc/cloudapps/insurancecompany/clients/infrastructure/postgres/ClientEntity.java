package es.urjc.cloudapps.insurancecompany.clients.infrastructure.postgres;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class ClientEntity {

    @Id
    private String id;

    private String name;

    private String surname;

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private String number;
}
