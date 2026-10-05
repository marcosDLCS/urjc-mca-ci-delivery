package es.urjc.cloudapps.insurancecompany.clients.application.find;

import java.util.Objects;

public class ClientFinderResponse {

  private final String id;
  private final String name;
  private final String surname;
  private final String country;
  private final String city;
  private final String postalCode;
  private final String street;
  private final String number;

  public ClientFinderResponse(
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

  public static Builder builder() {
    return new Builder();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getCountry() {
    return country;
  }

  public String getCity() {
    return city;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getStreet() {
    return street;
  }

  public String getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ClientFinderResponse that = (ClientFinderResponse) o;
    return Objects.equals(id, that.id)
        && Objects.equals(name, that.name)
        && Objects.equals(surname, that.surname)
        && Objects.equals(country, that.country)
        && Objects.equals(city, that.city)
        && Objects.equals(postalCode, that.postalCode)
        && Objects.equals(street, that.street)
        && Objects.equals(number, that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, country, city, postalCode, street, number);
  }

  @Override
  public String toString() {
    return "ClientFinderResponse{"
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

  public static class Builder {
    private String id;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    private String number;

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder surname(String surname) {
      this.surname = surname;
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

    public ClientFinderResponse build() {
      return new ClientFinderResponse(id, name, surname, country, city, postalCode, street, number);
    }
  }
}
