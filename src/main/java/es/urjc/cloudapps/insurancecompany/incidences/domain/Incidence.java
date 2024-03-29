package es.urjc.cloudapps.insurancecompany.incidences.domain;

import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;

import javax.money.CurrencyUnit;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Incidence {

    private final IncidenceId id;

    private final InsuranceId insuranceId;

    private final LocalDateTime date;

    private final String description;

    private final CoverageIncidence coverageIncidence;

    private final IncidenceAmount amount;

    private IncidenceStatus status;

    public Incidence(final IncidenceId id, final InsuranceId insuranceId, final CoverageIncidence coverageIncidence,
                     final IncidenceAmount amount, final IncidenceStatus status, final String description) {
        ensureIdIsPresent(id);
        ensureInsuranceIdIsPresent(insuranceId);
        ensureCoverageIncidenceIsPresent(coverageIncidence);
        ensureAmountIsPresent(amount);
        ensureDescriptionIsPresent(description);

        this.id                = id;
        this.insuranceId       = insuranceId;
        this.date              = LocalDateTime.now();
        this.coverageIncidence = coverageIncidence;
        this.amount            = amount;
        this.description       = description;
        this.status            = status;
    }

    private static void ensureIdIsPresent(final IncidenceId id) {
        if (id == null) throw new IllegalArgumentException("Incidence id must not be null");
    }

    private static void ensureInsuranceIdIsPresent(final InsuranceId id) {
        if (id == null) throw new IllegalArgumentException("Incidence insurance id must not be null");
    }

    private static void ensureCoverageIncidenceIsPresent(final CoverageIncidence ci) {
        if (ci == null) throw new IllegalArgumentException("Incidence coverage incidence must not be null");
    }

    private static void ensureAmountIsPresent(final IncidenceAmount ia) {
        if (ia == null) throw new IllegalArgumentException("Incidence amount must not be null");
    }

    private static void ensureDescriptionIsPresent(final String desc) {
        if (desc == null || desc.isBlank())
            throw new IllegalArgumentException("Incidence description must not be null");
    }

    public IncidenceId getId() {
        return id;
    }

    public String getIdAsString() {
        if (this.id != null) {
            return this.id.getId();
        } else {
            return null;
        }
    }

    public InsuranceId getInsuranceId() {
        return insuranceId;
    }

    public String getInsuranceIdAsString() {
        if (this.insuranceId != null && this.insuranceId.getId() != null) {
            return this.insuranceId.getId();
        } else {
            return null;
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public CoverageIncidence getCoverageIncidence() {
        return coverageIncidence;
    }

    public String getCoverageIncidenceIdAsString() {
        if (this.coverageIncidence != null && this.coverageIncidence.getId() != null) {
            return this.coverageIncidence.getId().getId();
        } else {
            return null;
        }
    }

    public IncidenceAmount getAmount() {
        return amount;
    }

    public BigDecimal getAmountValue() {
        return this.amount != null ? this.amount.getAmount() : null;
    }

    public CurrencyUnit getAmountCurrency() {
        return this.amount != null ? this.amount.getCurrency() : null;
    }

    public IncidenceStatus getStatus() {
        return status;
    }

    public String getStatusAsString() {
        return this.status != null ? this.status.name() : null;
    }

    public void accept() {
        this.status = IncidenceStatus.ACCEPTED;
    }

    public void markAsFraud() {
        this.status = IncidenceStatus.SUSPICION_OF_FRAUD;
    }

    public void markAsNotCovered() {
        this.status = IncidenceStatus.NOT_COVERED;
    }

    @Override
    public String toString() {
        return "Incidence{" +
                "id=" + id +
                ", insuranceId=" + insuranceId +
                ", date=" + date +
                ", coverageIncidence=" + coverageIncidence +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
