package es.urjc.cloudapps.insurancecompany.insurances.domain;

public class HouseRegistry {

    private final String registry;

    public HouseRegistry(final String registry) {
        ensureRegistryIsPresent(registry);
        this.registry = registry;
    }

    private static void ensureRegistryIsPresent(final String reg) {
        if (reg == null || reg.isBlank()) throw new IllegalArgumentException("Registry must not be null or empty");
    }

    public String getRegistry() {
        return registry;
    }

    @Override
    public String toString() {
        return "HouseRegistry{" +
                "registry='" + registry + '\'' +
                '}';
    }
}
