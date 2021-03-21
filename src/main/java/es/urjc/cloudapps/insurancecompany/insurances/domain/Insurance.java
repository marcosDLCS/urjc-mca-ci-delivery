package es.urjc.cloudapps.insurancecompany.insurances.domain;

import es.urjc.cloudapps.insurancecompany.clients.domain.ClientId;

import java.time.LocalDateTime;
import java.util.Set;

public class Insurance {

    private final InsuranceId id;

    private final ClientId clientId;

    private final LocalDateTime date;

    private final House house;

    private final Set<Coverage> coverages;

    public Insurance(final InsuranceId id, final ClientId clientId, final House house, final Set<Coverage> coverages) {
        ensureIdIsPresent(id);
        ensureClientIdIsPresent(clientId);
        ensureHouseIsPresent(house);
        ensureCoveragesArePresent(coverages);
        ensureCoveragesAreNotEmpty(coverages);

        this.id        = id;
        this.clientId  = clientId;
        this.date      = LocalDateTime.now();
        this.house     = house;
        this.coverages = coverages;
    }

    private static void ensureIdIsPresent(final InsuranceId id) {
        if (id == null) throw new IllegalArgumentException("Insurance id must not be null");
    }

    private static void ensureClientIdIsPresent(final ClientId id) {
        if (id == null) throw new IllegalArgumentException("Insurance client id must not be null");
    }

    private static void ensureHouseIsPresent(final House hs) {
        if (hs == null) throw new IllegalArgumentException("Insurance house must not be null");
    }

    private static void ensureCoveragesArePresent(final Set<Coverage> cov) {
        if (cov == null) throw new IllegalArgumentException("Insurance coverages must not be null");
    }

    private static void ensureCoveragesAreNotEmpty(final Set<Coverage> cov) {
        if (cov.isEmpty()) throw new IllegalArgumentException("Insurance coverages must not be empty");
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

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", date=" + date +
                ", house=" + house +
                ", coverages=" + coverages +
                '}';
    }
}
