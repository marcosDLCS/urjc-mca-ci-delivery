package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class IncidenceDto {

  private String id;
  private String insuranceId;
  private LocalDateTime date;
  private String incidenceType;
  private String description;
  private BigDecimal amount;
  private String currency;
  private String status;

  public IncidenceDto() {}

  public IncidenceDto(
      String id,
      String insuranceId,
      LocalDateTime date,
      String incidenceType,
      String description,
      BigDecimal amount,
      String currency,
      String status) {
    this.id = id;
    this.insuranceId = insuranceId;
    this.date = date;
    this.incidenceType = incidenceType;
    this.description = description;
    this.amount = amount;
    this.currency = currency;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getInsuranceId() {
    return insuranceId;
  }

  public void setInsuranceId(String insuranceId) {
    this.insuranceId = insuranceId;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getIncidenceType() {
    return incidenceType;
  }

  public void setIncidenceType(String incidenceType) {
    this.incidenceType = incidenceType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
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
    IncidenceDto that = (IncidenceDto) o;
    return Objects.equals(id, that.id)
        && Objects.equals(insuranceId, that.insuranceId)
        && Objects.equals(date, that.date)
        && Objects.equals(incidenceType, that.incidenceType)
        && Objects.equals(description, that.description)
        && Objects.equals(amount, that.amount)
        && Objects.equals(currency, that.currency)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, insuranceId, date, incidenceType, description, amount, currency, status);
  }

  @Override
  public String toString() {
    return "IncidenceDto{"
        + "id='"
        + id
        + '\''
        + ", insuranceId='"
        + insuranceId
        + '\''
        + ", date="
        + date
        + ", incidenceType='"
        + incidenceType
        + '\''
        + ", description='"
        + description
        + '\''
        + ", amount="
        + amount
        + ", currency='"
        + currency
        + '\''
        + ", status='"
        + status
        + '\''
        + '}';
  }
}
