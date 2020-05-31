package es.urjc.cloudapps.insurancecompany.insurances.domain;

import es.urjc.cloudapps.insurancecompany.shared.domain.Uuid;

public class InsuranceId extends Uuid {

    public InsuranceId(String id) {
        super(id);
    }

    public InsuranceId() {
        super();
    }
}
