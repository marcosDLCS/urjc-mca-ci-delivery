package es.urjc.cloudapps.insurancecompany.insurances.application.find;

import es.urjc.cloudapps.insurancecompany.insurances.domain.Insurance;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceFinder {

    private final InsuranceRepository insuranceRepository;

    public InsuranceFinder(final InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<Insurance> findAll() {
        return insuranceRepository.findAll();
    }

    public Insurance findOne(final InsuranceId id) {
        return insuranceRepository.findOne(id);
    }
}
