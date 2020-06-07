package es.urjc.cloudapps.insurancecompany.incidences.domain;

import es.urjc.cloudapps.insurancecompany.shared.domain.Uuid;

public class IncidenceId extends Uuid {

    public IncidenceId(final String id) {
        super(id);
    }

    public IncidenceId() {
        super();
    }
}
