package es.urjc.cloudapps.insurancecompany.clients.infrastructure.http;

import java.util.Objects;

public class ClientDto {

  private String id;
  private String name;
  private String surname;
  private String country;
  private String city;
  private String postalCode;
  private String street;
  private String number;

  public ClientDto() {}

  public ClientDto(
      String id,
      String name,
      String surname,
      String country,
      String city,
      String postalCode,
      String street,
      String number) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.country = country;
    this.city = city;
    this.postalCode = postalCode;
    this.street = street;
    this.number = number;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
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
    ClientDto clientDto = (ClientDto) o;
    return Objects.equals(id, clientDto.id)
        && Objects.equals(name, clientDto.name)
        && Objects.equals(surname, clientDto.surname)
        && Objects.equals(country, clientDto.country)
        && Objects.equals(city, clientDto.city)
        && Objects.equals(postalCode, clientDto.postalCode)
        && Objects.equals(street, clientDto.street)
        && Objects.equals(number, clientDto.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, country, city, postalCode, street, number);
  }

  @Override
  public String toString() {
    return "ClientDto{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", surname='"
        + surname
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
