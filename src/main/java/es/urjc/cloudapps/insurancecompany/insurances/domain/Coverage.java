package es.urjc.cloudapps.insurancecompany.insurances.domain;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidence;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class Coverage {

    private final String name;

    private Set<CoverageIncidence> coverageIncidences = new HashSet<>();

    public Coverage(final String name) {

        Assert.isTrue(!StringUtils.isEmpty(name), "Coverage name must not be null");

        this.name = name;
    }

    public Coverage(final String name, final Set<CoverageIncidence> coverageIncidences) {

        Assert.isTrue(!StringUtils.isEmpty(name), "Coverage name must not be null or empty");
        Assert.isTrue(coverageIncidences != null, "Coverage incidences must not be null");
        Assert.isTrue(!coverageIncidences.isEmpty(), "Coverage incidences must not be empty");

        this.name = name;
        this.coverageIncidences = coverageIncidences;
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
