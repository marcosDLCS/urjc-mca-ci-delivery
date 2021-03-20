package es.urjc.cloudapps.insurancecompany.insurances.application.find;

import es.urjc.cloudapps.insurancecompany.insurances.domain.Insurance;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static es.urjc.cloudapps.insurancecompany.insurances.application.find.InsuranceFinderMapper.insuranceToInsuranceFinderResponse;

@Service
public class InsuranceFinder {

    private final InsuranceRepository insuranceRepository;

    public InsuranceFinder(final InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<InsuranceFinderResponse> findAll() {
        final List<Insurance> insurances = insuranceRepository.findAll();
        return insurances.stream()
                .map(InsuranceFinderMapper::insuranceToInsuranceFinderResponse)
                .collect(Collectors.toList());
    }

    public InsuranceFinderResponse findOne(final String id) {
        final Insurance insurance = insuranceRepository.findOne(new InsuranceId(id));
        return insuranceToInsuranceFinderResponse(insurance);
    }
}
