package es.urjc.cloudapps.insurancecompany.clients.application.create;

import java.util.Objects;

public class CreateClientCommand {

  private String name;
  private String surname;
  private String country;
  private String city;
  private String postalCode;
  private String street;
  private String number;

  public CreateClientCommand() {}

  public CreateClientCommand(
      String name,
      String surname,
      String country,
      String city,
      String postalCode,
      String street,
      String number) {
    this.name = name;
    this.surname = surname;
    this.country = country;
    this.city = city;
    this.postalCode = postalCode;
    this.street = street;
    this.number = number;
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
    CreateClientCommand that = (CreateClientCommand) o;
    return Objects.equals(name, that.name)
        && Objects.equals(surname, that.surname)
        && Objects.equals(country, that.country)
        && Objects.equals(city, that.city)
        && Objects.equals(postalCode, that.postalCode)
        && Objects.equals(street, that.street)
        && Objects.equals(number, that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, country, city, postalCode, street, number);
  }

  @Override
  public String toString() {
    return "CreateClientCommand{"
        + "name='"
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
