package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2;

import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.insurances.domain.*;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.InsuranceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class H2InsuranceRepository implements InsuranceRepository {

    private final H2InsuranceEntityRepository h2InsuranceEntityRepository;
    private final InsuranceMapper insuranceMapper;

    public H2InsuranceRepository(H2InsuranceEntityRepository h2InsuranceEntityRepository) {
        this.h2InsuranceEntityRepository = h2InsuranceEntityRepository;
        this.insuranceMapper = Mappers.getMapper(InsuranceMapper.class);
    }

    @Override
    public List<Insurance> findAll() {

        final List<InsuranceEntity> insurances = h2InsuranceEntityRepository.findAll();
        return insurances.stream().map(this::insuranceEntityToInsurance).collect(Collectors.toList());
    }

    @Override
    public Insurance findOne(InsuranceId id) {

        final Optional<InsuranceEntity> insurance = h2InsuranceEntityRepository.findById(id.getId());
        return insurance.map(this::insuranceEntityToInsurance).orElse(null);
    }

    @Override
    public Insurance findByHouseRegistry(HouseRegistry registry) {

        final Optional<InsuranceEntity> insurance = Optional.ofNullable(
                h2InsuranceEntityRepository.findByHouseRegistry(registry.getRegistry()));
        return insurance.map(this::insuranceEntityToInsurance).orElse(null);
    }

    @Override
    public void save(Insurance insurance) {
        h2InsuranceEntityRepository.save(insuranceMapper.insuranceToInsuranceEntity(insurance));
    }

    private Insurance insuranceEntityToInsurance(final InsuranceEntity entity) {

        return new Insurance(
                new InsuranceId(entity.getId()),
                new ClientId(entity.getClient().getId()),
                new House(
                        new HouseRegistry(entity.getHouseRegistry()),
                        new HouseAddress(
                                entity.getHouseCountry(),
                                entity.getHouseCity(),
                                entity.getHousePostalCode(),
                                entity.getHouseStreet(),
                                entity.getHouseNumber()
                        )
                ),
                entity.getCoverages().stream().map(CoverageEntity::getId)
                        .map(Coverage::new).collect(Collectors.toSet())
        );
    }
}
