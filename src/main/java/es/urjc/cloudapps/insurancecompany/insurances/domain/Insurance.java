package es.urjc.cloudapps.insurancecompany.insurances.domain;

import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Set;

public class Insurance {

    private final InsuranceId id;

    private final ClientId clientId;

    private final LocalDateTime date;

    private final House house;

    private final Set<Coverage> coverages;

    public Insurance(final InsuranceId id, final ClientId clientId, final House house, final Set<Coverage> coverages) {

        Assert.isTrue(id != null, "Insurance id must not be null");
        Assert.isTrue(clientId != null, "Insurance client id must not be null");
        Assert.isTrue(house != null, "Insurance house must not be null");
        Assert.isTrue(coverages != null, "Insurance coverages must not be null");
        Assert.isTrue(!coverages.isEmpty(), "Insurance coverages must not be empty");

        this.id = id;
        this.clientId = clientId;
        this.date = LocalDateTime.now();
        this.house = house;
        this.coverages = coverages;
    }

    public InsuranceId getId() {
        return id;
    }

    public String getIdAsString() {
        if (this.id != null) {
            return this.id.getId();
        } else {
            return null;
        }
    }

    public ClientId getClientId() {
        return clientId;
    }

    public String getClientIdAsString() {
        if (this.clientId != null && this.clientId.getId() != null) {
            return this.clientId.getId();
        } else {
            return null;
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public House getHouse() {
        return house;
    }

    public Set<Coverage> getCoverages() {
        return coverages;
    }
}
