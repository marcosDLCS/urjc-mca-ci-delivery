package es.urjc.cloudapps.insurancecompany.unit.incidences.domain;

import es.urjc.cloudapps.insurancecompany.incidences.domain.CoverageIncidenceId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoverageIncidenceIdTest {

    @ParameterizedTest
    @DisplayName("Ensure missing id throws correct exception")
    @NullAndEmptySource
    void ensure_missing_uuid_throws_exception(final String id) {

        assertThrows(IllegalArgumentException.class, () -> new CoverageIncidenceId(id));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing id exception has correct message")
    @NullAndEmptySource
    void ensure_missing_uuid_exception_has_correct_message(final String id) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CoverageIncidenceId(id));
        assertThat(exception.getMessage()).isEqualTo("Coverage id must not be null or empty");
    }

    @Test
    @DisplayName("Ensure valid uuid returns a new object")
    void ensure_valid_uuid_returns_a_new_object() {

        assertThat(new CoverageIncidenceId(UUID.randomUUID().toString())).isNotNull();
    }
}