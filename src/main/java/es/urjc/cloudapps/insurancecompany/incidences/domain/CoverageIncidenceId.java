package es.urjc.cloudapps.insurancecompany.incidences.domain;

public class CoverageIncidenceId {

    private final String id;

    public CoverageIncidenceId(final String id) {
        ensureIdIsPresent(id);
        this.id = id;
    }

    private static void ensureIdIsPresent(final String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Coverage id must not be null or empty");
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CoverageIncidenceId{" +
                "id='" + id + '\'' +
                '}';
    }
}