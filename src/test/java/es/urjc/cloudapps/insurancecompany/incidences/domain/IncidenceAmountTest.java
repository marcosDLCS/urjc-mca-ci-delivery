package es.urjc.cloudapps.insurancecompany.incidences.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("all")
class IncidenceAmountTest {

    @Test
    @DisplayName("Ensure missing amount throws correct exception")
    void ensure_missing_amount_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new IncidenceAmount(null, "EUR"));
    }

    @Test
    @DisplayName("Ensure missing amount throws correct exception")
    void eensure_missing_amount_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new IncidenceAmount(null, "EUR"));
        assertThat(exception.getMessage()).isEqualTo("Amount must not be null");
    }

    @ParameterizedTest
    @DisplayName("Ensure negative or zero amount throws correct exception")
    @ValueSource(doubles = {0D, -1D})
    void ensure_negative_or_zero_amount_throws_exception(final double amount) {

        assertThrows(IllegalArgumentException.class, () -> new IncidenceAmount(BigDecimal.valueOf(amount), "EUR"));
    }

    @ParameterizedTest
    @DisplayName("Ensure negative or zero amount throws correct exception")
    @ValueSource(doubles = {0D, -1D})
    void eensure_negative_or_zero_amount_exception_has_correct_message(final double amount) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new IncidenceAmount(BigDecimal.valueOf(amount), "EUR"));
        assertThat(exception.getMessage()).isEqualTo("Amount must be positive");
    }

    @ParameterizedTest
    @DisplayName("Ensure missing currency throws correct exception")
    @NullAndEmptySource
    void ensure_missing_currency_throws_exception(final String currency) {

        assertThrows(IllegalArgumentException.class, () -> new IncidenceAmount(BigDecimal.TEN, currency));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing currency exception has correct message")
    @NullAndEmptySource
    void ensure_missing_currency_exception_has_correct_message(final String currency) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new IncidenceAmount(BigDecimal.TEN, currency));
        assertThat(exception.getMessage()).isEqualTo("Currency string must not be null or empty");
    }

    @Test
    @DisplayName("Ensure invalid currency throws correct exception")
    void ensure_invalid_currency_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new IncidenceAmount(BigDecimal.TEN, "random-currency"));
    }

    @Test
    @DisplayName("Ensure invalid currency exception has correct message")
    void ensure_invalid_currency_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new IncidenceAmount(BigDecimal.TEN, "random-currency"));
        assertThat(exception.getMessage()).isEqualTo("Currency must be valid");
    }

    @ParameterizedTest
    @DisplayName("Ensure valid params returns a new object")
    @ValueSource(strings = {"EUR", "USD", "GBP", "JPY"})
    void ensure_valid_params_returns_a_new_object(final String currency) {

        assertThat(new IncidenceAmount(BigDecimal.TEN, currency)).isNotNull();
    }

}