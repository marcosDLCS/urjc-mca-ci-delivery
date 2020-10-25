package es.urjc.cloudapps.insurancecompany.incidences.domain;

import java.util.HashMap;
import java.util.Map;

public enum IncidenceStatus {

    ACCEPTED,
    NOT_COVERED,
    SUSPICION_OF_FRAUD;

    private static final Map<String, IncidenceStatus> CACHE;

    static {
        CACHE = new HashMap<>();
        for (final IncidenceStatus is : values()) {
            CACHE.put(is.name(), is);
        }
    }

    public static IncidenceStatus fromString(final String value) {
        if (value == null || value.isEmpty() || value.isBlank()) return null;
        return CACHE.getOrDefault(value, null);
    }
}
