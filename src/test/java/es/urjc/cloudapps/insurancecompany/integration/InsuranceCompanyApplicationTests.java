package es.urjc.cloudapps.insurancecompany.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InsuranceCompanyApplicationTests {

  private static final Logger log = LoggerFactory.getLogger(InsuranceCompanyApplicationTests.class);

  @Test
  void contextLoads() {
    log.info("Context loading...");
    assertThat(Boolean.TRUE).isTrue();
  }
}
