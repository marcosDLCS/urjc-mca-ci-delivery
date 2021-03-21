package es.urjc.cloudapps.insurancecompany.insurances.domain;

public class House {

    private final HouseRegistry registry;

    private final HouseAddress address;

    public House(final HouseRegistry registry, final HouseAddress address) {
        ensureRegistryIsPresent(registry);
        ensureAddressIsPresent(address);

        this.registry = registry;
        this.address  = address;
    }

    private static void ensureRegistryIsPresent(final HouseRegistry reg) {
        if (reg == null) throw new IllegalArgumentException("House registry must not be null");
    }

    private static void ensureAddressIsPresent(final HouseAddress addr) {
        if (addr == null) throw new IllegalArgumentException("House address must not be null");
    }

    public HouseRegistry getRegistry() {
        return registry;
    }

    public HouseAddress getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "House{" +
                "registry=" + registry +
                ", address=" + address +
                '}';
    }
}
