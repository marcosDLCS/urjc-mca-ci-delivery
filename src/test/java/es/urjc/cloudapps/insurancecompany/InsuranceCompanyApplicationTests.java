package es.urjc.cloudapps.insurancecompany;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InsuranceCompanyApplicationTests {

    @Test
    void contextLoads() {
        log.info("Context loading...");
        assertThat(Boolean.TRUE).isTrue();
    }

}
