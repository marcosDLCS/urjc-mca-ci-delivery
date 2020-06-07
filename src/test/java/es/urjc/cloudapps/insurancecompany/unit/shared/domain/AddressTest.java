package es.urjc.cloudapps.insurancecompany.unit.shared.domain;

import es.urjc.cloudapps.insurancecompany.shared.domain.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddressTest {

    @ParameterizedTest
    @DisplayName("Ensure missing country throws correct exception")
    @NullAndEmptySource
    void ensure_missing_country_throws_exception(final String country) {

        assertThrows(IllegalArgumentException.class, () -> new Address(country,
                "random-city", "random-postal-code", "random-street", "random-number"));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing country exception has correct message")
    @NullAndEmptySource
    void ensure_missing_country_exception_has_correct_message(final String country) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Address(country, "random-city", "random-postal-code",
                        "random-street", "random-number"));
        assertThat(exception.getMessage()).isEqualTo("Country must not be null or empty");
    }

    @ParameterizedTest
    @DisplayName("Ensure missing city throws correct exception")
    @NullAndEmptySource
    void ensure_missing_city_throws_exception(final String city) {

        assertThrows(IllegalArgumentException.class, () -> new Address("random-country",
                city, "random-postal-code", "random-street", "random-number"));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing city exception has correct message")
    @NullAndEmptySource
    void ensure_missing_city_exception_has_correct_message(final String city) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Address("random-country", city, "random-postal-code",
                        "random-street", "random-number"));
        assertThat(exception.getMessage()).isEqualTo("City must not be null or empty");
    }

    @ParameterizedTest
    @DisplayName("Ensure missing postal code throws correct exception")
    @NullAndEmptySource
    void ensure_missing_postal_code_throws_exception(final String postalCode) {

        assertThrows(IllegalArgumentException.class, () -> new Address("random-country",
                "random-city", postalCode, "random-street", "random-number"));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing postal code exception has correct message")
    @NullAndEmptySource
    void ensure_missing_postal_code_exception_has_correct_message(final String postalCode) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Address("random-country", "random-city", postalCode,
                        "random-street", "random-number"));
        assertThat(exception.getMessage()).isEqualTo("Postal code must not be null or empty");
    }

    @ParameterizedTest
    @DisplayName("Ensure missing street throws correct exception")
    @NullAndEmptySource
    void ensure_missing_street_throws_exception(final String street) {

        assertThrows(IllegalArgumentException.class, () -> new Address("random-country",
                "random-city", "random-postal-code", street, "random-number"));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing street exception has correct message")
    @NullAndEmptySource
    void ensure_missing_street_exception_has_correct_message(final String street) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Address("random-country", "random-city", "random-postal-code",
                        street, "random-number"));
        assertThat(exception.getMessage()).isEqualTo("Street must not be null or empty");
    }

    @Test
    @DisplayName("Ensure valid params returns a new object")
    void ensure_valid_params_returns_a_new_object() {

        assertThat(new Address("random-country", "random-city", "random-postal-code",
                "random-street", "random-number")).isNotNull();
    }

}