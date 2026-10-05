package es.urjc.cloudapps.insurancecompany.insurances.application.create;

import java.util.Objects;
import java.util.Set;

public class CreateInsuranceCommand {

  private String clientId;
  private String houseRegistry;
  private String houseCountry;
  private String houseCity;
  private String housePostalCode;
  private String houseStreet;
  private String houseNumber;
  private Set<String> coverages;

  public CreateInsuranceCommand() {}

  public CreateInsuranceCommand(
      String clientId,
      String houseRegistry,
      String houseCountry,
      String houseCity,
      String housePostalCode,
      String houseStreet,
      String houseNumber,
      Set<String> coverages) {
    this.clientId = clientId;
    this.houseRegistry = houseRegistry;
    this.houseCountry = houseCountry;
    this.houseCity = houseCity;
    this.housePostalCode = housePostalCode;
    this.houseStreet = houseStreet;
    this.houseNumber = houseNumber;
    this.coverages = coverages;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getHouseRegistry() {
    return houseRegistry;
  }

  public void setHouseRegistry(String houseRegistry) {
    this.houseRegistry = houseRegistry;
  }

  public String getHouseCountry() {
    return houseCountry;
  }

  public void setHouseCountry(String houseCountry) {
    this.houseCountry = houseCountry;
  }

  public String getHouseCity() {
    return houseCity;
  }

  public void setHouseCity(String houseCity) {
    this.houseCity = houseCity;
  }

  public String getHousePostalCode() {
    return housePostalCode;
  }

  public void setHousePostalCode(String housePostalCode) {
    this.housePostalCode = housePostalCode;
  }

  public String getHouseStreet() {
    return houseStreet;
  }

  public void setHouseStreet(String houseStreet) {
    this.houseStreet = houseStreet;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public Set<String> getCoverages() {
    return coverages;
  }

  public void setCoverages(Set<String> coverages) {
    this.coverages = coverages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CreateInsuranceCommand that = (CreateInsuranceCommand) o;
    return Objects.equals(clientId, that.clientId)
        && Objects.equals(houseRegistry, that.houseRegistry)
        && Objects.equals(houseCountry, that.houseCountry)
        && Objects.equals(houseCity, that.houseCity)
        && Objects.equals(housePostalCode, that.housePostalCode)
        && Objects.equals(houseStreet, that.houseStreet)
        && Objects.equals(houseNumber, that.houseNumber)
        && Objects.equals(coverages, that.coverages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        clientId,
        houseRegistry,
        houseCountry,
        houseCity,
        housePostalCode,
        houseStreet,
        houseNumber,
        coverages);
  }

  @Override
  public String toString() {
    return "CreateInsuranceCommand{"
        + "clientId='"
        + clientId
        + '\''
        + ", houseRegistry='"
        + houseRegistry
        + '\''
        + ", houseCountry='"
        + houseCountry
        + '\''
        + ", houseCity='"
        + houseCity
        + '\''
        + ", housePostalCode='"
        + housePostalCode
        + '\''
        + ", houseStreet='"
        + houseStreet
        + '\''
        + ", houseNumber='"
        + houseNumber
        + '\''
        + ", coverages="
        + coverages
        + '}';
  }
}
