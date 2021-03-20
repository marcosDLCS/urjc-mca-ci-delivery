package es.urjc.cloudapps.insurancecompany.incidences.application.find;

import es.urjc.cloudapps.insurancecompany.incidences.domain.Incidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static es.urjc.cloudapps.insurancecompany.incidences.application.find.IncidenceFinderMapper.incidenceToIncidenceFinderResponse;

@Service
public class IncidenceFinder {

    private final IncidenceRepository incidenceRepository;

    public IncidenceFinder(final IncidenceRepository incidenceRepository) {
        this.incidenceRepository = incidenceRepository;
    }

    public List<IncidenceFinderResponse> findAll() {
        final List<Incidence> incidences = incidenceRepository.findAll();
        return incidences.stream()
                .map(IncidenceFinderMapper::incidenceToIncidenceFinderResponse)
                .collect(Collectors.toList());
    }

    public IncidenceFinderResponse findOne(final String id) {
        final Incidence incidence = incidenceRepository.findOne(new IncidenceId(id));
        return incidenceToIncidenceFinderResponse(incidence);
    }
}
