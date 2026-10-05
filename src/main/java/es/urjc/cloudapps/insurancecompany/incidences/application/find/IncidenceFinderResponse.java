package es.urjc.cloudapps.insurancecompany.incidences.application.find;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.money.CurrencyUnit;

public class IncidenceFinderResponse {

  private final String id;
  private final String insuranceId;
  private final LocalDateTime date;
  private final String description;
  private final String coverageIncidence;
  private final BigDecimal amount;
  private final CurrencyUnit currency;
  private String status;

  public IncidenceFinderResponse(
      String id,
      String insuranceId,
      LocalDateTime date,
      String description,
      String coverageIncidence,
      BigDecimal amount,
      CurrencyUnit currency,
      String status) {
    this.id = id;
    this.insuranceId = insuranceId;
    this.date = date;
    this.description = description;
    this.coverageIncidence = coverageIncidence;
    this.amount = amount;
    this.currency = currency;
    this.status = status;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getId() {
    return id;
  }

  public String getInsuranceId() {
    return insuranceId;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public String getCoverageIncidence() {
    return coverageIncidence;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public CurrencyUnit getCurrency() {
    return currency;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IncidenceFinderResponse that = (IncidenceFinderResponse) o;
    return Objects.equals(id, that.id)
        && Objects.equals(insuranceId, that.insuranceId)
        && Objects.equals(date, that.date)
        && Objects.equals(description, that.description)
        && Objects.equals(coverageIncidence, that.coverageIncidence)
        && Objects.equals(amount, that.amount)
        && Objects.equals(currency, that.currency)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, insuranceId, date, description, coverageIncidence, amount, currency, status);
  }

  @Override
  public String toString() {
    return "IncidenceFinderResponse{"
        + "id='"
        + id
        + '\''
        + ", insuranceId='"
        + insuranceId
        + '\''
        + ", date="
        + date
        + ", description='"
        + description
        + '\''
        + ", coverageIncidence='"
        + coverageIncidence
        + '\''
        + ", amount="
        + amount
        + ", currency="
        + currency
        + ", status='"
        + status
        + '\''
        + '}';
  }

  public static class Builder {
    private String id;
    private String insuranceId;
    private LocalDateTime date;
    private String description;
    private String coverageIncidence;
    private BigDecimal amount;
    private CurrencyUnit currency;
    private String status;

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder insuranceId(String insuranceId) {
      this.insuranceId = insuranceId;
      return this;
    }

    public Builder date(LocalDateTime date) {
      this.date = date;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder coverageIncidence(String coverageIncidence) {
      this.coverageIncidence = coverageIncidence;
      return this;
    }

    public Builder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public Builder currency(CurrencyUnit currency) {
      this.currency = currency;
      return this;
    }

    public Builder status(String status) {
      this.status = status;
      return this;
    }

    public IncidenceFinderResponse build() {
      return new IncidenceFinderResponse(
          id, insuranceId, date, description, coverageIncidence, amount, currency, status);
    }
  }
}
