package es.urjc.cloudapps.insurancecompany.insurances.domain;

import org.springframework.util.Assert;

public class House {

    private final HouseRegistry registry;

    private final HouseAddress address;

    public House(HouseRegistry registry, HouseAddress address) {

        Assert.isTrue(registry != null, "House registry must not be null");
        Assert.isTrue(address != null, "House address must not be null");

        this.registry = registry;
        this.address = address;
    }

    public HouseRegistry getRegistry() {
        return registry;
    }

    public HouseAddress getAddress() {
        return address;
    }
}
