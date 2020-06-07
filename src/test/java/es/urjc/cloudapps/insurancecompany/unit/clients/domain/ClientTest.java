package es.urjc.cloudapps.insurancecompany.unit.clients.domain;

import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static es.urjc.cloudapps.insurancecompany.unit.clients.shared.ClientTestDataFactory.getValidClientAddress;
import static es.urjc.cloudapps.insurancecompany.unit.clients.shared.ClientTestDataFactory.getValidClientId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientTest {

    @Test
    @DisplayName("Ensure missing client id throws correct exception")
    void ensure_missing_client_id_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new Client(null, "random-name",
                "random-surname", getValidClientAddress()));
    }

    @Test
    @DisplayName("Ensure missing client id exception has correct message")
    void ensure_missing_client_id_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Client(null, "random-name", "random-surname", getValidClientAddress()));
        assertThat(exception.getMessage()).isEqualTo("Client id must not be null");
    }

    @ParameterizedTest
    @DisplayName("Ensure missing client name throws correct exception")
    @NullAndEmptySource
    void ensure_missing_client_name_throws_exception(final String name) {

        assertThrows(IllegalArgumentException.class,
                () -> new Client(getValidClientId(), name, "random-surname", getValidClientAddress()));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing client name exception has correct message")
    @NullAndEmptySource
    void ensure_missing_client_name_exception_has_correct_message(final String name) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Client(getValidClientId(), name, "random-surname", getValidClientAddress()));
        assertThat(exception.getMessage()).isEqualTo("Client name must not be null or empty");
    }

    @ParameterizedTest
    @DisplayName("Ensure missing client surname throws correct exception")
    @NullAndEmptySource
    void ensure_missing_client_surname_throws_exception(final String surname) {

        assertThrows(IllegalArgumentException.class,
                () -> new Client(getValidClientId(), "random-name", surname, getValidClientAddress()));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing client surname exception has correct message")
    @NullAndEmptySource
    void ensure_missing_client_surname_exception_has_correct_message(final String surname) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Client(getValidClientId(), "random-name", surname, getValidClientAddress()));
        assertThat(exception.getMessage()).isEqualTo("Client surname must not be null or empty");
    }

    @Test
    @DisplayName("Ensure missing client address throws correct exception")
    void ensure_missing_client_address_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new Client(getValidClientId(),
                "random-name", "random-surname", null));
    }

    @Test
    @DisplayName("Ensure missing client address exception has correct message")
    void ensure_missing_client_address_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Client(getValidClientId(), "random-name", "random-surname", null));
        assertThat(exception.getMessage()).isEqualTo("Client address must not be null");
    }

    @Test
    @DisplayName("Ensure valid client params returns a new object")
    void ensure_valid_client_params_returns_a_new_object() {

        assertThat(new Client(getValidClientId(), "random-name", "random-surname",
                getValidClientAddress())).isNotNull();
    }

}