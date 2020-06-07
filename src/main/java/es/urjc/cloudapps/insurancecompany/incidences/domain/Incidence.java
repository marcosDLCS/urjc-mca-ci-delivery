package es.urjc.cloudapps.insurancecompany.incidences.domain;

import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

        Assert.isTrue(id != null, "Incidence id must not be null");
        Assert.isTrue(insuranceId != null, "Incidence insurance id must not be null");
        Assert.isTrue(coverageIncidence != null, "Incidence coverage incidence must not be null");
        Assert.isTrue(amount != null, "Incidence amount must not be null");
        Assert.isTrue(!StringUtils.isEmpty(description), "Incidence description must not be null");

        this.id = id;
        this.insuranceId = insuranceId;
        this.date = LocalDateTime.now();
        this.coverageIncidence = coverageIncidence;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public IncidenceId getId() {
        return id;
    }

    public InsuranceId getInsuranceId() {
        return insuranceId;
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

    public IncidenceAmount getAmount() {
        return amount;
    }

    public IncidenceStatus getStatus() {
        return status;
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
