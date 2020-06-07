package es.urjc.cloudapps.insurancecompany.unit.incidences.domain;

import es.urjc.cloudapps.insurancecompany.incidences.domain.*;
import es.urjc.cloudapps.insurancecompany.insurances.domain.InsuranceId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static es.urjc.cloudapps.insurancecompany.unit.incidences.shared.IncidenceTestDataFactory.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IncidenceTest {

    private IncidenceId validIncidenceId;
    private InsuranceId validInsuranceId;
    private CoverageIncidence validCoverageIncidence;
    private IncidenceAmount validIncidenceAmount;

    @BeforeEach
    void setup() {
        this.validIncidenceId = getValidIncidenceId();
        this.validInsuranceId = getValidInsuranceId();
        this.validCoverageIncidence = getValidCoverageIncidence();
        this.validIncidenceAmount = getValidIncidenceAmount();
    }

    @Test
    @DisplayName("Ensure missing incidence id throws correct exception")
    void ensure_missing_incidence_id_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new Incidence(null,
                this.validInsuranceId,
                this.validCoverageIncidence,
                this.validIncidenceAmount, IncidenceStatus.ACCEPTED,
                "random-description"));
    }

    @Test
    @DisplayName("Ensure missing incidence id throws correct exception")
    void ensure_missing_incidence_id_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Incidence(null, this.validInsuranceId, this.validCoverageIncidence,
                        this.validIncidenceAmount, IncidenceStatus.ACCEPTED, "random-description"));
        assertThat(exception.getMessage()).isEqualTo("Incidence id must not be null");
    }

    @Test
    @DisplayName("Ensure missing incidence insurance id throws correct exception")
    void ensure_missing_incidence_insurance_id_throws_exception() {

        assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, null, this.validCoverageIncidence,
                        this.validIncidenceAmount, IncidenceStatus.ACCEPTED, "random-description"));
    }

    @Test
    @DisplayName("Ensure missing incidence insurance id throws correct exception")
    void ensure_missing_incidence_insurance_id_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, null, this.validCoverageIncidence,
                        this.validIncidenceAmount, IncidenceStatus.ACCEPTED, "random-description"));
        assertThat(exception.getMessage()).isEqualTo("Incidence insurance id must not be null");
    }

    @Test
    @DisplayName("Ensure missing incidence coverage incidence throws correct exception")
    void ensure_missing_incidence_coverage_incidence_throws_exception() {

        assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, this.validInsuranceId, null,
                        this.validIncidenceAmount, IncidenceStatus.ACCEPTED, "random-description"));
    }

    @Test
    @DisplayName("Ensure missing incidence coverage incidence throws correct exception")
    void ensure_missing_incidence_coverage_incidence_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, this.validInsuranceId, null,
                        this.validIncidenceAmount, IncidenceStatus.ACCEPTED, "random-description"));
        assertThat(exception.getMessage()).isEqualTo("Incidence coverage incidence must not be null");
    }

    @Test
    @DisplayName("Ensure missing incidence amount throws correct exception")
    void ensure_missing_incidence_amount_throws_exception() {

        assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, this.validInsuranceId,
                        this.validCoverageIncidence, null, IncidenceStatus.ACCEPTED,
                        "random-description"));
    }

    @Test
    @DisplayName("Ensure missing incidence amount throws correct exception")
    void ensure_missing_incidence_amount_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, this.validInsuranceId, this.validCoverageIncidence,
                        null, IncidenceStatus.ACCEPTED, "random-description"));
        assertThat(exception.getMessage()).isEqualTo("Incidence amount must not be null");
    }

    @ParameterizedTest
    @DisplayName("Ensure missing incidence description throws correct exception")
    @NullAndEmptySource
    void ensure_missing_incidence_description_throws_exception(final String description) {

        assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, this.validInsuranceId, this.validCoverageIncidence,
                        this.validIncidenceAmount, IncidenceStatus.ACCEPTED, description));
    }

    @ParameterizedTest
    @DisplayName("Ensure missing incidence description throws correct exception")
    @NullAndEmptySource
    void ensure_missing_incidence_description_exception_has_correct_message(final String description) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Incidence(this.validIncidenceId, this.validInsuranceId, this.validCoverageIncidence,
                        this.validIncidenceAmount, IncidenceStatus.ACCEPTED, description));
        assertThat(exception.getMessage()).isEqualTo("Incidence description must not be null");
    }

    @Test
    @DisplayName("Ensure valid params returns a new object")
    void ensure_valid_params_returns_a_new_object() {

        assertThat(new Incidence(this.validIncidenceId, this.validInsuranceId, this.validCoverageIncidence,
                this.validIncidenceAmount, IncidenceStatus.ACCEPTED, "random-description")).isNotNull();
    }
}