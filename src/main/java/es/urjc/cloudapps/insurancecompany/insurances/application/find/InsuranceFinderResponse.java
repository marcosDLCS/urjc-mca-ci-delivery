package es.urjc.cloudapps.insurancecompany.insurances.application.find;

import java.util.Objects;
import java.util.Set;

public class InsuranceFinderResponse {

  private String id;
  private String clientId;
  private String registry;
  private String country;
  private String city;
  private String postalCode;
  private String street;
  private String number;
  private Set<String> coverages;

  public InsuranceFinderResponse() {}

  public InsuranceFinderResponse(
      String id,
      String clientId,
      String registry,
      String country,
      String city,
      String postalCode,
      String street,
      String number,
      Set<String> coverages) {
    this.id = id;
    this.clientId = clientId;
    this.registry = registry;
    this.country = country;
    this.city = city;
    this.postalCode = postalCode;
    this.street = street;
    this.number = number;
    this.coverages = coverages;
  }

  public static Builder builder() {
    return new Builder();
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

  public String getRegistry() {
    return registry;
  }

  public void setRegistry(String registry) {
    this.registry = registry;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
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
    InsuranceFinderResponse that = (InsuranceFinderResponse) o;
    return Objects.equals(id, that.id)
        && Objects.equals(clientId, that.clientId)
        && Objects.equals(registry, that.registry)
        && Objects.equals(country, that.country)
        && Objects.equals(city, that.city)
        && Objects.equals(postalCode, that.postalCode)
        && Objects.equals(street, that.street)
        && Objects.equals(number, that.number)
        && Objects.equals(coverages, that.coverages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, clientId, registry, country, city, postalCode, street, number, coverages);
  }

  @Override
  public String toString() {
    return "InsuranceFinderResponse{"
        + "id='"
        + id
        + '\''
        + ", clientId='"
        + clientId
        + '\''
        + ", registry='"
        + registry
        + '\''
        + ", country='"
        + country
        + '\''
        + ", city='"
        + city
        + '\''
        + ", postalCode='"
        + postalCode
        + '\''
        + ", street='"
        + street
        + '\''
        + ", number='"
        + number
        + '\''
        + ", coverages="
        + coverages
        + '}';
  }

  public static class Builder {
    private String id;
    private String clientId;
    private String registry;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    private String number;
    private Set<String> coverages;

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder clientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    public Builder registry(String registry) {
      this.registry = registry;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public Builder city(String city) {
      this.city = city;
      return this;
    }

    public Builder postalCode(String postalCode) {
      this.postalCode = postalCode;
      return this;
    }

    public Builder street(String street) {
      this.street = street;
      return this;
    }

    public Builder number(String number) {
      this.number = number;
      return this;
    }

    public Builder coverages(Set<String> coverages) {
      this.coverages = coverages;
      return this;
    }

    public InsuranceFinderResponse build() {
      return new InsuranceFinderResponse(
          id, clientId, registry, country, city, postalCode, street, number, coverages);
    }
  }
}
