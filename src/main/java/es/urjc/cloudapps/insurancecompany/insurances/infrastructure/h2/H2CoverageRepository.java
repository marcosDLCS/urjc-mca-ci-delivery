package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.h2.CoverageIncidenceEntity;
import es.urjc.cloudapps.insurancecompany.insurances.domain.Coverage;
import es.urjc.cloudapps.insurancecompany.insurances.domain.CoverageRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class H2CoverageRepository implements CoverageRepository {

    private final H2CoverageEntityRepository h2CoverageEntityRepository;

    public H2CoverageRepository(final H2CoverageEntityRepository h2CoverageEntityRepository) {
        this.h2CoverageEntityRepository = h2CoverageEntityRepository;
    }

    @Override
    public List<Coverage> findAll() {

        final List<CoverageEntity> coverageEntities = h2CoverageEntityRepository.findAll();
        return coverageEntities.stream()
                .map(this::coverageEntityToCoverage).collect(Collectors.toList());
    }

    @Override
    public Coverage findById(String id) {

        final Optional<CoverageEntity> coverageEntity = h2CoverageEntityRepository.findById(id);
        return coverageEntity.map(this::coverageEntityToCoverage).orElse(null);
    }

    private Coverage coverageEntityToCoverage(final CoverageEntity coverageEntity) {

        final Set<CoverageIncidence> coverageIncidences = coverageEntity.getIncidences()
                .stream().map(CoverageIncidenceEntity::getId)
                .map(i -> new CoverageIncidence(new CoverageIncidenceId(i))).collect(Collectors.toSet());
        return new Coverage(coverageEntity.getId(), coverageIncidences);
    }
}
