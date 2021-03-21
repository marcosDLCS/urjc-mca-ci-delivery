package es.urjc.cloudapps.insurancecompany.shared.domain;

public class Address {

    private final String country;

    private final String city;

    private final String postalCode;

    private final String street;

    private final String number;

    public Address(final String country, final String city, final String postalCode, final String street,
                   final String number) {
        ensureCountryIsPresent(country);
        ensureCityIsPresent(city);
        ensurePostalCodeIsPresent(postalCode);
        ensureStreetIsPresent(street);

        this.country    = country;
        this.city       = city;
        this.postalCode = postalCode;
        this.street     = street;
        this.number     = (number != null && !number.isBlank()) ? "W/0" : number;
    }

    private static void ensureCountryIsPresent(final String cnt) {
        if (cnt == null || cnt.isBlank()) throw new IllegalArgumentException("Country must not be null or empty");
    }

    private static void ensureCityIsPresent(final String city) {
        if (city == null || city.isBlank()) throw new IllegalArgumentException("City must not be null or empty");
    }

    private static void ensurePostalCodeIsPresent(final String pc) {
        if (pc == null || pc.isBlank()) throw new IllegalArgumentException("Postal code must not be null or empty");
    }

    private static void ensureStreetIsPresent(final String street) {
        if (street == null || street.isBlank()) throw new IllegalArgumentException("Street must not be null or empty");
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
    public String toString() {
        return this.street + ", " + this.number + ". " + this.postalCode + ". " + this.city + ", " + this.country;
    }
}
