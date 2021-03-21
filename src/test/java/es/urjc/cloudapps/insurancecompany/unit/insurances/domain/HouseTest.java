package es.urjc.cloudapps.insurancecompany.unit.insurances.domain;

import es.urjc.cloudapps.insurancecompany.insurances.domain.House;
import es.urjc.cloudapps.insurancecompany.insurances.domain.HouseAddress;
import es.urjc.cloudapps.insurancecompany.insurances.domain.HouseRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static es.urjc.cloudapps.insurancecompany.unit.insurances.shared.InsuranceTestDataFactory.getValidHouseAddress;
import static es.urjc.cloudapps.insurancecompany.unit.insurances.shared.InsuranceTestDataFactory.getValidHouseRegistry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HouseTest {

    private HouseRegistry validHouseRegistry;
    private HouseAddress  validHouseAddress;

    @BeforeEach
    void setup() {
        this.validHouseRegistry = getValidHouseRegistry();
        this.validHouseAddress  = getValidHouseAddress();
    }

    @Test
    @DisplayName("Ensure missing house registry throws correct exception")
    void ensure_missing_house_registry_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new House(null, this.validHouseAddress));
    }

    @Test
    @DisplayName("Ensure missing house registry exception has correct message")
    void ensure_missing_house_registry_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new House(null, this.validHouseAddress));
        assertThat(exception.getMessage()).isEqualTo("House registry must not be null");
    }

    @Test
    @DisplayName("Ensure missing house address throws correct exception")
    void ensure_missing_house_address_throws_exception() {

        assertThrows(IllegalArgumentException.class, () -> new House(this.validHouseRegistry, null));
    }

    @Test
    @DisplayName("Ensure missing house address exception has correct message")
    void ensure_missing_house_address_exception_has_correct_message() {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new House(this.validHouseRegistry, null));
        assertThat(exception.getMessage()).isEqualTo("House address must not be null");
    }

    @Test
    @DisplayName("Ensure valid params returns a new object")
    void ensure_valid_params_returns_a_new_object() {

        assertThat(new House(this.validHouseRegistry, this.validHouseAddress)).isNotNull();
    }

}