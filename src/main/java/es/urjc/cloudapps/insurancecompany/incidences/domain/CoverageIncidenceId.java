package es.urjc.cloudapps.insurancecompany.incidences.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class CoverageIncidenceId {

    private final String id;

    public CoverageIncidenceId(String id) {

        Assert.isTrue(!StringUtils.isEmpty(id), "Incidence id must not be null");

        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CoverageIncidenceId)) return false;

        CoverageIncidenceId that = (CoverageIncidenceId) o;

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
