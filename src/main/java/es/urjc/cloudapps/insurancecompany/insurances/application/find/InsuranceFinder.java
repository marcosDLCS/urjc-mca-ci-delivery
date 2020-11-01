package es.urjc.cloudapps.insurancecompany.insurances.application.find;

import es.urjc.cloudapps.insurancecompany.insurances.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceFinder {

    private final InsuranceRepository insuranceRepository;

    public InsuranceFinder(final InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<InsuranceFinderResponse> findAll() {
        final List<Insurance> insurances = insuranceRepository.findAll();
        return insurances.stream().map(this::fromInsuranceToInsuranceResponse).collect(Collectors.toList());
    }

    public InsuranceFinderResponse findOne(final String id) {
        final Insurance insurance = insuranceRepository.findOne(new InsuranceId(id));
        return fromInsuranceToInsuranceResponse(insurance);
    }

    private InsuranceFinderResponse fromInsuranceToInsuranceResponse(final Insurance insurance) {

        // TODO: Tell don´t ask

        final var builder = InsuranceFinderResponse.builder()
                .id(insurance.getId() != null ? insurance.getId().getId() : null)
                .clientId(insurance.getClientId() != null ? insurance.getClientId().getId() : null);

        final var house = insurance.getHouse();
        HouseAddress houseAddress = null;

        if (house != null) {
            builder.registry(house.getRegistry() != null ? house.getRegistry().getRegistry() : null);
            houseAddress = house.getAddress();
        }

        if (houseAddress != null) {
            builder.country(houseAddress.getCountry()).city(houseAddress.getCity())
                    .postalCode(houseAddress.getPostalCode()).street(houseAddress.getStreet())
                    .number(houseAddress.getNumber());
        }

        builder.coverages(insurance.getCoverages().stream().map(Coverage::getName).collect(Collectors.toSet()));

        return builder.build();
    }
}
