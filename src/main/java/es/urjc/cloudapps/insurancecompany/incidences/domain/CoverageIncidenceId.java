package es.urjc.cloudapps.insurancecompany.incidences.domain;

import es.urjc.cloudapps.insurancecompany.shared.domain.Uuid;

public class CoverageIncidenceId extends Uuid {

    public CoverageIncidenceId(String id) {
        super(id);
    }

    public CoverageIncidenceId() {
        super();
    }
}
