package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.h2;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidenceRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class H2CoverageIncidenceRepository implements CoverageIncidenceRepository {

    private final H2CoverageIncidenceEntityRepository h2CoverageIncidenceEntityRepository;

    public H2CoverageIncidenceRepository(H2CoverageIncidenceEntityRepository h2CoverageIncidenceEntityRepository) {
        this.h2CoverageIncidenceEntityRepository = h2CoverageIncidenceEntityRepository;
    }

    @Override
    public CoverageIncidence findOne(CoverageIncidenceId id) {

        final Optional<CoverageIncidenceEntity> coverageIncidence =
                h2CoverageIncidenceEntityRepository.findById(id.getId());
        return coverageIncidence.map(this::coverageIncidenceEntityToCoverageIncidence).orElse(null);
    }

    private CoverageIncidence coverageIncidenceEntityToCoverageIncidence(final CoverageIncidenceEntity entity) {
        return new CoverageIncidence(new CoverageIncidenceId(entity.getId()));
    }
}
