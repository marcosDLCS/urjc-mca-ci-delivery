package es.urjc.cloudapps.insurancecompany.insurances.domain;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public final class HouseAddress {

    private final String country;

    private final String city;

    private final String postalCode;

    private final String street;

    private final String number;

    public HouseAddress(String country, String city, String postalCode, String street, String number) {

        Assert.isTrue(!StringUtils.isEmpty(country), "Country must not be null or empty");
        Assert.isTrue(!StringUtils.isEmpty(city), "City must not be null or empty");
        Assert.isTrue(!StringUtils.isEmpty(postalCode), "Postal code must not be null or empty");
        Assert.isTrue(!StringUtils.isEmpty(street), "Street must not be null or empty");

        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = StringUtils.isEmpty(number) ? "W/0" : number;
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
