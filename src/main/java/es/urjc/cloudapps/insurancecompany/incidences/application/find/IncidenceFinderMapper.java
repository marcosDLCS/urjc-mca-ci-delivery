package es.urjc.cloudapps.insurancecompany.incidences.application.find;

import es.urjc.cloudapps.insurancecompany.incidences.domain.Incidence;

final class IncidenceFinderMapper {

    private IncidenceFinderMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static IncidenceFinderResponse incidenceToIncidenceFinderResponse(final Incidence incidence) {
        return IncidenceFinderResponse.builder()
                .id(incidence.getIdAsString())
                .insuranceId(incidence.getInsuranceIdAsString())
                .date(incidence.getDate())
                .description(incidence.getDescription())
                .coverageIncidence(incidence.getCoverageIncidenceIdAsString())
                .amount(incidence.getAmountValue())
                .currency(incidence.getAmountCurrency())
                .status(incidence.getStatusAsString())
                .build();
    }
}
