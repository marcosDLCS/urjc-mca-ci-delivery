package es.urjc.cloudapps.insurancecompany.incidences.application.create;

import java.math.BigDecimal;
import java.util.Objects;

public class CreateIncidenceCommand {

  private String id;
  private String insuranceId;
  private String incidenceType;
  private String description;
  private BigDecimal amount;
  private String currency;
  private String status;

  public CreateIncidenceCommand() {}

  public CreateIncidenceCommand(
      String id,
      String insuranceId,
      String incidenceType,
      String description,
      BigDecimal amount,
      String currency,
      String status) {
    this.id = id;
    this.insuranceId = insuranceId;
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
    CreateIncidenceCommand that = (CreateIncidenceCommand) o;
    return Objects.equals(id, that.id)
        && Objects.equals(insuranceId, that.insuranceId)
        && Objects.equals(incidenceType, that.incidenceType)
        && Objects.equals(description, that.description)
        && Objects.equals(amount, that.amount)
        && Objects.equals(currency, that.currency)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, insuranceId, incidenceType, description, amount, currency, status);
  }

  @Override
  public String toString() {
    return "CreateIncidenceCommand{"
        + "id='"
        + id
        + '\''
        + ", insuranceId='"
        + insuranceId
        + '\''
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
