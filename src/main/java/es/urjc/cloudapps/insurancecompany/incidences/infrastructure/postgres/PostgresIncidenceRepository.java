package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres;

import es.urjc.cloudapps.insurancecompany.incidences.domain.*;
import es.urjc.cloudapps.insurancecompany.incidences.shared.IncidenceMapper;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres.InsuranceEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostgresIncidenceRepository implements IncidenceRepository {

    private final PostgresIncidenceEntityRepository postgresIncidenceEntityRepository;
    private final IncidenceMapper incidenceMapper;

    public PostgresIncidenceRepository(PostgresIncidenceEntityRepository postgresIncidenceEntityRepository) {
        this.postgresIncidenceEntityRepository = postgresIncidenceEntityRepository;
        this.incidenceMapper = Mappers.getMapper(IncidenceMapper.class);
    }

    @Override
    public List<Incidence> findAll() {

        final List<IncidenceEntity> incidences = postgresIncidenceEntityRepository.findAll();
        return incidences.stream().map(this::incidenceEntityToIncidence).collect(Collectors.toList());
    }

    @Override
    public Incidence findOne(IncidenceId id) {

        final Optional<IncidenceEntity> incidence = postgresIncidenceEntityRepository.findById(id.getId());
        return incidence.map(this::incidenceEntityToIncidence).orElse(null);
    }

    @Override
    public List<Incidence> findByInsuranceId(InsuranceId insuranceId) {

        final InsuranceEntity insuranceEntity = new InsuranceEntity();
        insuranceEntity.setId(insuranceId.getId());

        final List<IncidenceEntity> incidences = postgresIncidenceEntityRepository.findByInsurance(insuranceEntity);
        return incidences.stream().map(this::incidenceEntityToIncidence).collect(Collectors.toList());
    }

    @Override
    public void save(Incidence incidence) {

        final IncidenceEntity entity = incidenceMapper.incidenceToIncidenceEntity(incidence);
        postgresIncidenceEntityRepository.save(entity);
    }

    private Incidence incidenceEntityToIncidence(final IncidenceEntity incidenceEntity) {

        return new Incidence(
                new IncidenceId(incidenceEntity.getId()),
                new InsuranceId(incidenceEntity.getInsurance().getId()),
                new CoverageIncidence(
                        new CoverageIncidenceId(incidenceEntity.getType())
                ),
                new IncidenceAmount(incidenceEntity.getAmount(), incidenceEntity.getCurrency()),
                IncidenceStatus.valueOf(incidenceEntity.getStatus()),
                incidenceEntity.getDescription()
        );

    }
}
