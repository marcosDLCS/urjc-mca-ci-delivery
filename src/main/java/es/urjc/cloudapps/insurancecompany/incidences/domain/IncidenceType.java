package es.urjc.cloudapps.insurancecompany.incidences.domain;

import java.util.HashMap;
import java.util.Map;

public enum IncidenceType {

    FLOOD,
    EARTHQUAKE,
    DEEP_ASTEROID_IMPACT,
    TSUNAMI,
    TORNADO,
    ACCIDENT;

    private static final Map<String, IncidenceType> CACHE;

    static {
        CACHE = new HashMap<>();
        for (final IncidenceType it : values()) {
            CACHE.put(it.name(), it);
        }
    }

    public static IncidenceType fromString(final String value) {
        if (value == null || value.isEmpty() || value.isBlank()) return null;
        return CACHE.getOrDefault(value, null);
    }
}
