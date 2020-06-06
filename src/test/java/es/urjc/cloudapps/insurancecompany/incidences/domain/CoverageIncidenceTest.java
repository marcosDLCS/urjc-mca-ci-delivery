package es.urjc.cloudapps.insurancecompany.incidences.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static es.urjc.cloudapps.insurancecompany.incidences.shared.IncidenceTestDataFactory.getValidCoverageIncidenceId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoverageIncidenceTest {

    @Test
    @DisplayName("Ensure missing incidence id throws correct exception")
    void ensure_missing_incidence_id_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new CoverageIncidence(null));
    }

    @Test
    @DisplayName("Ensure missing incidence id throws correct exception")
    void eensure_missing_incidence_id_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CoverageIncidence(null));
        assertThat(exception.getMessage()).isEqualTo("Incidence id must not be null");
    }

    @Test
    @DisplayName("Ensure valid coverage incidence params returns a new object")
    void ensure_valid_uuid_returns_a_new_object() {

        assertThat(new CoverageIncidence(getValidCoverageIncidenceId())).isNotNull();
    }

}

