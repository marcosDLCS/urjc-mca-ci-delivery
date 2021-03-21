package es.urjc.cloudapps.insurancecompany.insurances.domain;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidence;

import java.util.HashSet;
import java.util.Set;

public class Coverage {

    private final String name;

    private Set<CoverageIncidence> coverageIncidences = new HashSet<>();

    public Coverage(final String name) {
        ensureNameIsPresent(name);

        this.name = name;
    }

    public Coverage(final String name, final Set<CoverageIncidence> coverageIncidences) {
        ensureNameIsPresent(name);
        ensureIncidencesArePresent(coverageIncidences);
        ensureIncidencesAreNotEmpty(coverageIncidences);

        this.name               = name;
        this.coverageIncidences = coverageIncidences;
    }

    private static void ensureNameIsPresent(final String n) {
        if (n == null || n.isBlank()) throw new IllegalArgumentException("Coverage name must not be null or empty");
    }

    private static void ensureIncidencesArePresent(final Set<CoverageIncidence> inc) {
        if (inc == null) throw new IllegalArgumentException("Coverage incidences must not be null");
    }

    private static void ensureIncidencesAreNotEmpty(final Set<CoverageIncidence> inc) {
        if (inc.isEmpty()) throw new IllegalArgumentException("Coverage incidences must not be empty");
    }

    public String getName() {
        return name;
    }

    public Set<CoverageIncidence> getCoverageIncidences() {
        return coverageIncidences;
    }

    @Override
    public String toString() {
        return "Coverage{" +
                "name='" + name + '\'' +
                '}';
    }
}
