package es.urjc.cloudapps.insurancecompany.incidences.domain;

import java.util.Objects;

public class CoverageIncidence {

    private final CoverageIncidenceId id;

    public CoverageIncidence(final CoverageIncidenceId id) {
        ensureIdIsPresent(id);

        this.id = id;
    }

    private static void ensureIdIsPresent(final CoverageIncidenceId id) {
        if (id == null) throw new IllegalArgumentException("Incidence id must not be null");
    }

    public CoverageIncidenceId getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoverageIncidence)) return false;
        CoverageIncidence that = (CoverageIncidence) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "CoverageIncidence{" +
                "id=" + id +
                '}';
    }
}
