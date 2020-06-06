package es.urjc.cloudapps.insurancecompany.incidences.domain;

import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;

import java.math.BigDecimal;
import java.util.UUID;

public final class IncidenceTestDataFactory {

    private IncidenceTestDataFactory() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static CoverageIncidenceId getValidCoverageIncidenceId() {
        return new CoverageIncidenceId(UUID.randomUUID().toString());
    }

    public static IncidenceId getValidIncidenceId() {
        return new IncidenceId(UUID.randomUUID().toString());
    }

    public static InsuranceId getValidInsuranceId() {
        return new InsuranceId(UUID.randomUUID().toString());
    }

    public static CoverageIncidence getValidCoverageIncidence() {
        return new CoverageIncidence(getValidCoverageIncidenceId());
    }

    public static IncidenceAmount getValidIncidenceAmount() {
        return new IncidenceAmount(BigDecimal.TEN, "EUR");
    }

}
