package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http;

import java.util.Objects;

public class HouseDTO {

  private String registry;
  private String country;
  private String city;
  private String postalCode;
  private String street;
  private String number;

  public HouseDTO() {}

  public HouseDTO(
      String registry,
      String country,
      String city,
      String postalCode,
      String street,
      String number) {
    this.registry = registry;
    this.country = country;
    this.city = city;
    this.postalCode = postalCode;
    this.street = street;
    this.number = number;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HouseDTO houseDTO = (HouseDTO) o;
    return Objects.equals(registry, houseDTO.registry)
        && Objects.equals(country, houseDTO.country)
        && Objects.equals(city, houseDTO.city)
        && Objects.equals(postalCode, houseDTO.postalCode)
        && Objects.equals(street, houseDTO.street)
        && Objects.equals(number, houseDTO.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registry, country, city, postalCode, street, number);
  }

  @Override
  public String toString() {
    return "HouseDTO{"
        + "registry='"
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
        + '}';
  }
}
