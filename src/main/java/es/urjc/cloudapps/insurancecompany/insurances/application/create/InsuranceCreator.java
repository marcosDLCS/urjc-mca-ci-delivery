package es.urjc.cloudapps.insurancecompany.insurances.application.create;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import es.urjc.cloudapps.insurancecompany.insurances.domain.*;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InsuranceCreator {

    private final InsuranceRepository insuranceRepository;
    private final ClientRepository    clientRepository;
    private final CoverageRepository  coverageRepository;

    public InsuranceCreator(final InsuranceRepository insuranceRepository,
                            final ClientRepository clientRepository,
                            final CoverageRepository coverageRepository) {

        this.insuranceRepository = insuranceRepository;
        this.clientRepository    = clientRepository;
        this.coverageRepository  = coverageRepository;
    }

    public void create(final CreateInsuranceCommand command) {
        ensureClientExists(command.getClientId());
        ensureHouseRegistryNotExists(command.getHouseRegistry());
        ensureCoveragesExists(command.getCoverages());

        final Insurance insurance = new Insurance(
                new InsuranceId(),
                new ClientId(command.getClientId()),
                new House(
                        new HouseRegistry(command.getHouseRegistry()),
                        new HouseAddress(
                                command.getHouseCountry(),
                                command.getHouseCity(),
                                command.getHousePostalCode(),
                                command.getHouseStreet(),
                                command.getHouseNumber()
                        )
                ),
                command.getCoverages().stream().map(Coverage::new).collect(Collectors.toSet())
        );

        insuranceRepository.save(insurance);
    }

    private void ensureClientExists(final String id) {
        final Client client = clientRepository.findOne(new ClientId(id));
        if (client == null) throw new IllegalArgumentException("Client does not exist");
    }

    private void ensureHouseRegistryNotExists(final String registry) {
        final Insurance insurance = insuranceRepository.findByHouseRegistry(new HouseRegistry(registry));
        if (insurance != null)
            throw new IllegalArgumentException("There is another insurance with the same house registry");
    }

    private void ensureCoveragesExists(final Set<String> coverages) {
        for (String cId : coverages) {
            if (coverageRepository.findById(cId) == null) throw new IllegalArgumentException("Coverage does not exist");
        }
    }
}
