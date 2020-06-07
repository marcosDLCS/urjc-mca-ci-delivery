package es.urjc.cloudapps.insurancecompany.shared.domain;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class Uuid {

    private final String id;

    public Uuid(final String id) {

        Assert.isTrue(!StringUtils.isEmpty(id), "Uuid must not be null or empty");
        Assert.isTrue(Uuid.validUuid(id), "Uuid must have the correct format");

        this.id = id;
    }

    public Uuid() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    private static boolean validUuid(final String id) {
        try {
            UUID.fromString(id);
            return Boolean.TRUE;
        } catch (final Exception e) {
            return Boolean.FALSE;
        }
    }
}
