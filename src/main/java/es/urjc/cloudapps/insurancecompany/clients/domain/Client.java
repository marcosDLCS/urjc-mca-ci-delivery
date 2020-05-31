package es.urjc.cloudapps.insurancecompany.clients.domain;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class Client {

    private final ClientId id;

    private final String name;

    private final String surname;

    private final ClientAddress address;

    public Client(ClientId id, String name, String surname, ClientAddress address) {

        Assert.isTrue(id != null, "Client id must not be null");
        Assert.isTrue(!StringUtils.isEmpty(name), "Client name must not be null or empty");
        Assert.isTrue(!StringUtils.isEmpty(surname), "Client surname must not be null or empty");
        Assert.isTrue(address != null, "Client address must not be null");

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public ClientId getId() {
        return id;
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
