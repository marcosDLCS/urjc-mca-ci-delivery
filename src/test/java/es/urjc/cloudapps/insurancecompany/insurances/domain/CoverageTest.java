package es.urjc.cloudapps.insurancecompany.insurances.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Collections;

import static es.urjc.cloudapps.insurancecompany.insurances.shared.InsuranceTestDataFactory.getValidCoverageIncidences;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoverageTest {

    @ParameterizedTest
    @DisplayName("Ensure missing coverage name throws correct exception")
    @NullAndEmptySource
    void ensure_missing_coverage_name_throws_exception(final String name) {

        assertThrows(IllegalArgumentException.class, () -> new Coverage(name, Collections.emptySet()));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing coverage name exception has correct message")
    @NullAndEmptySource
    void ensure_missing_coverage_name_exception_has_correct_message(final String name) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Coverage(name, Collections.emptySet()));
        assertThat(exception.getMessage()).isEqualTo("Coverage name must not be null or empty");
    }

    @Test
    @DisplayName("Ensure missing coverage incidences throws correct exception")
    void ensure_missing_coverage_incidences_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new Coverage("random-name", null));
    }

    @Test
    @DisplayName("Ensure missing coverage incidences exception has correct message")
    void ensure_missing_coverage_incidences_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Coverage("random-name", null));
        assertThat(exception.getMessage()).isEqualTo("Coverage incidences must not be null");
    }

    @Test
    @DisplayName("Ensure empty coverage incidences throws correct exception")
    void ensure_empty_coverage_incidences_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new Coverage("random-name", Collections.emptySet()));
    }

    @Test
    @DisplayName("Ensure empty coverage incidences exception has correct message")
    void ensure_empty_coverage_incidences_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Coverage("random-name", Collections.emptySet()));
        assertThat(exception.getMessage()).isEqualTo("Coverage incidences must not be empty");
    }

    @Test
    @DisplayName("Ensure valid params returns a new object")
    void ensure_valid_params_returns_a_new_object() {

        assertThat(new Coverage("random-name", getValidCoverageIncidences())).isNotNull();
    }

}