package es.urjc.cloudapps.insurancecompany.clients.domain;

import org.springframework.util.Assert;

public class Client {

    private final ClientId id;

    private final String name;

    private final String surname;

    private final ClientAddress address;

    public Client(final ClientId id, final String name, final String surname, final ClientAddress address) {

        // TODO: Use non-framework utils to ensure domain properties

        Assert.isTrue(id != null, "Client id must not be null");
        Assert.isTrue(name != null && !name.isBlank(), "Client name must not be null or empty");
        Assert.isTrue(surname != null && !surname.isBlank(), "Client surname must not be null or empty");
        Assert.isTrue(address != null, "Client address must not be null");

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public ClientId getId() {
        return id;
    }

    public String getIdAsString() {
        if (this.id != null) {
            return this.id.getId();
        } else {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ClientAddress getAddress() {
        return address;
    }

}
