package es.urjc.cloudapps.insurancecompany.unit.incidences.shared;

import es.urjc.cloudapps.insurancecompany.incidences.application.find.IncidenceFinderResponse;
import es.urjc.cloudapps.insurancecompany.incidences.domain.*;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;

import java.math.BigDecimal;
import java.util.UUID;

public final class IncidenceTestDataFactory {

    private IncidenceTestDataFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
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

    public static Incidence getValidIncidence() {
        return new Incidence(getValidIncidenceId(), getValidInsuranceId(), getValidCoverageIncidence(),
                getValidIncidenceAmount(), IncidenceStatus.ACCEPTED, "random-description");
    }

    public static IncidenceFinderResponse getValidIncidenceFinderResponse() {
        return fromIncidenceToIncidenceResponse(getValidIncidence());
    }

    private static IncidenceFinderResponse fromIncidenceToIncidenceResponse(final Incidence incidence) {
        return IncidenceFinderResponse.builder()
                .id(incidence.getId() != null ? incidence.getId().getId() : null)
                .insuranceId(incidence.getInsuranceId() != null ? incidence.getInsuranceId().getId() : null)
                .date(incidence.getDate())
                .description(incidence.getDescription())
                .coverageIncidence(incidence.getCoverageIncidence() != null ?
                        incidence.getCoverageIncidence().getId().getId() : null)
                .amount(incidence.getAmount() != null ? incidence.getAmount().getAmount() : null)
                .currency(incidence.getAmount() != null ? incidence.getAmount().getCurrency() : null)
                .status(incidence.getStatus() != null ? incidence.getStatus().name() : null)
                .build();
    }

}
