package es.urjc.cloudapps.insurancecompany.incidences.application.find;

import es.urjc.cloudapps.insurancecompany.incidences.domain.Incidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidenceFinder {

    private final IncidenceRepository incidenceRepository;

    public IncidenceFinder(final IncidenceRepository incidenceRepository) {
        this.incidenceRepository = incidenceRepository;
    }

    public List<IncidenceFinderResponse> findAll() {
        final List<Incidence> incidences = incidenceRepository.findAll();
        return incidences.stream().map(this::fromIncidenceToIncidenceResponse).collect(Collectors.toList());
    }

    public IncidenceFinderResponse findOne(final String id) {
        final Incidence incidence = incidenceRepository.findOne(new IncidenceId(id));
        return fromIncidenceToIncidenceResponse(incidence);
    }

    private IncidenceFinderResponse fromIncidenceToIncidenceResponse(final Incidence incidence) {
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
