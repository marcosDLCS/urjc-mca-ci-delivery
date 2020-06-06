package es.urjc.cloudapps.insurancecompany.clients.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientIdTest {

    @ParameterizedTest
    @DisplayName("Ensure missing uuid throws correct exception")
    @NullAndEmptySource
    void ensure_missing_uuid_throws_exception(final String id) {

        assertThrows(IllegalArgumentException.class, () -> new ClientId(id));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing uuid exception has correct message")
    @NullAndEmptySource
    void ensure_missing_uuid_exception_has_correct_message(final String id) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ClientId(id));
        assertThat(exception.getMessage()).isEqualTo("Uuid must not be null or empty");
    }

    @Test
    @DisplayName("Ensure invalid uuid throws correct exception")
    void ensure_invalid_uuid_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new ClientId("invalid-id"));
    }

    @Test
    @DisplayName("Ensure invalid uuid exception has correct message")
    void ensure_invalid_uuid_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ClientId("invalid-id"));
        assertThat(exception.getMessage()).isEqualTo("Uuid must have the correct format");
    }

    @Test
    @DisplayName("Ensure valid uuid returns a new object")
    void ensure_valid_uuid_returns_a_new_object() {

        assertThat(new ClientId(UUID.randomUUID().toString())).isNotNull();
    }

}