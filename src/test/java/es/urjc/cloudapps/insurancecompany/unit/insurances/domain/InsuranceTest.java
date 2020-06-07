package es.urjc.cloudapps.insurancecompany.unit.insurances.domain;

import es.urjc.cloudapps.insurancecompany.insurances.domain.Insurance;
import es.urjc.cloudapps.insurancecompany.unit.clients.shared.ClientTestDataFactory;
import es.urjc.cloudapps.insurancecompany.unit.incidences.shared.IncidenceTestDataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static es.urjc.cloudapps.insurancecompany.unit.insurances.shared.InsuranceTestDataFactory.geValidCoverages;
import static es.urjc.cloudapps.insurancecompany.unit.insurances.shared.InsuranceTestDataFactory.getValidHouse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InsuranceTest {

    @Test
    @DisplayName("Ensure missing insurance id throws correct exception")
    void ensure_missing_insurance_id_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new Insurance(null,
                ClientTestDataFactory.getValidClientId(), getValidHouse(),
                geValidCoverages()));
    }

    @Test
    @DisplayName("Ensure missing insurance id exception has correct message")
    void ensure_missing_insurance_id_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Insurance(null, ClientTestDataFactory.getValidClientId(), getValidHouse(), geValidCoverages()));
        assertThat(exception.getMessage()).isEqualTo("Insurance id must not be null");
    }

    @Test
    @DisplayName("Ensure missing client id throws correct exception")
    void ensure_missing_client_id_throws_exception() {

        assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), null,
                getValidHouse(), geValidCoverages()));
    }

    @Test
    @DisplayName("Ensure missing client id exception has correct message")
    void ensure_missing_client_id_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), null, getValidHouse(), geValidCoverages()));
        assertThat(exception.getMessage()).isEqualTo("Insurance client id must not be null");
    }

    @Test
    @DisplayName("Ensure missing house throws correct exception")
    void ensure_missing_house_throws_exception() {

        assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(),
                        ClientTestDataFactory.getValidClientId(),
                null, geValidCoverages()));
    }

    @Test
    @DisplayName("Ensure missing house exception has correct message")
    void ensure_missing_house_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), ClientTestDataFactory.getValidClientId(), null, geValidCoverages()));
        assertThat(exception.getMessage()).isEqualTo("Insurance house must not be null");
    }

    @Test
    @DisplayName("Ensure missing coverages throws correct exception")
    void ensure_missing_coverages_throws_exception() {

        assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), ClientTestDataFactory.getValidClientId(),
                getValidHouse(), null));
    }

    @Test
    @DisplayName("Ensure missing coverages exception has correct message")
    void ensure_missing_coverages_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), ClientTestDataFactory.getValidClientId(), getValidHouse(), null));
        assertThat(exception.getMessage()).isEqualTo("Insurance coverages must not be null");
    }

    @Test
    @DisplayName("Ensure empty coverages throws correct exception")
    void ensure_empty_coverages_throws_exception() {

        assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), ClientTestDataFactory.getValidClientId(),
                getValidHouse(), Collections.emptySet()));
    }

    @Test
    @DisplayName("Ensure empty coverages exception has correct message")
    void ensure_empty_coverages_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), ClientTestDataFactory.getValidClientId(), getValidHouse(),
                        Collections.emptySet()));
        assertThat(exception.getMessage()).isEqualTo("Insurance coverages must not be empty");
    }

    @Test
    @DisplayName("Ensure valid params returns a new object")
    void ensure_valid_params_returns_a_new_object() {

        assertThat(new Insurance(IncidenceTestDataFactory.getValidInsuranceId(), ClientTestDataFactory.getValidClientId(), getValidHouse(), geValidCoverages()))
                .isNotNull();
    }

}