package es.urjc.cloudapps.insurancecompany.insurances.application.create;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import es.urjc.cloudapps.insurancecompany.clients.domain.ClientRepository;
import es.urjc.cloudapps.insurancecompany.insurances.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InsuranceCreator {

    private final InsuranceRepository insuranceRepository;
    private final ClientRepository clientRepository;
    private final CoverageRepository coverageRepository;

    public InsuranceCreator(final InsuranceRepository insuranceRepository,
                            final ClientRepository clientRepository,
                            final CoverageRepository coverageRepository) {

        this.insuranceRepository = insuranceRepository;
        this.clientRepository = clientRepository;
        this.coverageRepository = coverageRepository;
    }

    public void create(final CreateInsuranceCommand command) {

        Assert.isTrue(clientExists(command.getClientId()), "Client does not exist");
        Assert.isTrue(houseRegistryNotExists(command.getHouseRegistry()),
                "There is another insurance with the same house registry");
        Assert.isTrue(coveragesExists(command.getCoverages()),
                "There is another insurance with the same house registry");

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

    private boolean clientExists(final String id) {

        final Client client = clientRepository.findOne(new ClientId(id));
        return client != null;
    }

    private boolean houseRegistryNotExists(final String registry) {

        final Insurance insurance = insuranceRepository.findByHouseRegistry(new HouseRegistry(registry));
        return insurance == null;
    }

    private boolean coveragesExists(final Set<String> coverages) {

        for (String coverageId : coverages) {
            Coverage coverageFromDb = coverageRepository.findById(coverageId);
            if (coverageFromDb == null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
