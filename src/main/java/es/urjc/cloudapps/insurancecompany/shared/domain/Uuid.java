package es.urjc.cloudapps.insurancecompany.shared.domain;

import java.util.UUID;

public class Uuid {

    private final String id;

    public Uuid(final String id) {
        ensureIdIsPresent(id);
        ensureIdIsValid(id);

        this.id = id;
    }

    public Uuid() {
        this.id = UUID.randomUUID().toString();
    }

    private static void ensureIdIsPresent(final String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Uuid must not be null or empty");
    }

    private static void ensureIdIsValid(final String id) {
        if (!Uuid.validUuid(id)) throw new IllegalArgumentException("Uuid must have the correct format");
    }

    public String getId() {
        return id;
    }

    private static boolean validUuid(final String id) {
        try {
            UUID.fromString(id);
            return Boolean.TRUE;
        } catch (final Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public String toString() {
        return "Uuid{" +
                "id='" + id + '\'' +
                '}';
    }
}
