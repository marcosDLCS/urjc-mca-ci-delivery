package es.urjc.cloudapps.insurancecompany.incidences.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

public class CoverageIncidence {

    private final CoverageIncidenceId id;

    public CoverageIncidence(final CoverageIncidenceId id) {

        // TODO: Use non-framework utils to ensure domain properties

        Assert.isTrue(id != null, "Incidence id must not be null");

        this.id = id;
    }

    public CoverageIncidenceId getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CoverageIncidence)) return false;

        CoverageIncidence that = (CoverageIncidence) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }
}
