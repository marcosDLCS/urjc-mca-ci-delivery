package es.urjc.cloudapps.insurancecompany.incidences.domain;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class CoverageIncidenceId {

    private final String id;

    public CoverageIncidenceId(final String id) {

        // TODO: Use non-framework utils to ensure domain properties

        Assert.isTrue(!StringUtils.isEmpty(id), "Coverage id must not be null or empty");

        this.id = id;
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
