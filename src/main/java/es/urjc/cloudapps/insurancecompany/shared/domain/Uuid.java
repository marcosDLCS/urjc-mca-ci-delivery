package es.urjc.cloudapps.insurancecompany.shared.domain;

import java.util.UUID;

public class Uuid {

    private final String id;

    public Uuid(String id) {
        this.id = id;
    }

    public Uuid() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
