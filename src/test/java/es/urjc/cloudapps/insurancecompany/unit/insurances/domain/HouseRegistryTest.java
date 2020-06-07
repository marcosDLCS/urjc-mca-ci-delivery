package es.urjc.cloudapps.insurancecompany.unit.insurances.domain;

import es.urjc.cloudapps.insurancecompany.insurances.domain.HouseRegistry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HouseRegistryTest {

    @ParameterizedTest
    @DisplayName("Ensure missing registry throws correct exception")
    @NullAndEmptySource
    void ensure_missing_registry_throws_exception(final String registry) {

        assertThrows(IllegalArgumentException.class, () -> new HouseRegistry(registry));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing registry exception has correct message")
    @NullAndEmptySource
    void ensure_missing_registry_exception_has_correct_message(final String registry) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new HouseRegistry(registry));
        assertThat(exception.getMessage()).isEqualTo("Registry must not be null or empty");
    }

    @Test
    @DisplayName("Ensure valid params returns a new object")
    void ensure_valid_params_returns_a_new_object() {

        assertThat(new HouseRegistry("random-registry")).isNotNull();
    }

}