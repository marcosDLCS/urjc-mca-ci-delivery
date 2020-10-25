package es.urjc.cloudapps.insurancecompany.incidences.application.find;

import es.urjc.cloudapps.insurancecompany.incidences.domain.Incidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenceFinder {

    private final IncidenceRepository incidenceRepository;

    public IncidenceFinder(final IncidenceRepository incidenceRepository) {
        this.incidenceRepository = incidenceRepository;
    }

    public List<Incidence> findAll() {
        return incidenceRepository.findAll();
    }

    public Incidence findOne(final IncidenceId id) {
        return incidenceRepository.findOne(id);
    }

}
