package es.urjc.cloudapps.insurancecompany.insurances.domain;

import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class HouseRegistry {

    @Getter
    private final String registry;

    public HouseRegistry(final String registry) {

        Assert.isTrue(!StringUtils.isEmpty(registry), "Registry must not be null or empty");

        this.registry = registry;
    }
}
