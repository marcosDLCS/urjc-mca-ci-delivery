package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http;

import java.util.Objects;
import java.util.Set;

public class InsuranceDto {

  private String id;
  private String clientId;
  private HouseDTO house;
  private Set<String> coverages;

  public InsuranceDto() {}

  public InsuranceDto(String id, String clientId, HouseDTO house, Set<String> coverages) {
    this.id = id;
    this.clientId = clientId;
    this.house = house;
    this.coverages = coverages;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public HouseDTO getHouse() {
    return house;
  }

  public void setHouse(HouseDTO house) {
    this.house = house;
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
    InsuranceDto that = (InsuranceDto) o;
    return Objects.equals(id, that.id)
        && Objects.equals(clientId, that.clientId)
        && Objects.equals(house, that.house)
        && Objects.equals(coverages, that.coverages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientId, house, coverages);
  }

  @Override
  public String toString() {
    return "InsuranceDto{"
        + "id='"
        + id
        + '\''
        + ", clientId='"
        + clientId
        + '\''
        + ", house="
        + house
        + ", coverages="
        + coverages
        + '}';
  }
}
