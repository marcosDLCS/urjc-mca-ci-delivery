package es.urjc.cloudapps.insurancecompany.insurances.domain;

import java.util.List;

public interface CoverageRepository {

    List<Coverage> findAll();

    Coverage findById(final String id);
}
