package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidenceRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PostgresCoverageIncidenceRepository implements CoverageIncidenceRepository {

    private final PostgresCoverageIncidenceEntityRepository postgresCoverageIncidenceEntityRepository;

    public PostgresCoverageIncidenceRepository(PostgresCoverageIncidenceEntityRepository postgresCoverageIncidenceEntityRepository) {
        this.postgresCoverageIncidenceEntityRepository = postgresCoverageIncidenceEntityRepository;
    }

    @Override
    public CoverageIncidence findOne(CoverageIncidenceId id) {

        final Optional<CoverageIncidenceEntity> coverageIncidence =
                postgresCoverageIncidenceEntityRepository.findById(id.getId());
        return coverageIncidence.map(this::coverageIncidenceEntityToCoverageIncidence).orElse(null);
    }

    private CoverageIncidence coverageIncidenceEntityToCoverageIncidence(final CoverageIncidenceEntity entity) {
        return new CoverageIncidence(new CoverageIncidenceId(entity.getId()));
    }
}
