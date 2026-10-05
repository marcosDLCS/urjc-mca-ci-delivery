package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http;

import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InsuranceDto {

  private String id;

  private String clientId;

  private HouseDTO house;

  private Set<String> coverages;
}
