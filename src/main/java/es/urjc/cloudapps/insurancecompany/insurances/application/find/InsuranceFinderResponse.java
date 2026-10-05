package es.urjc.cloudapps.insurancecompany.insurances.application.find;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class InsuranceFinderResponse {

  private String id;

  private String clientId;

  private String registry;

  private String country;

  private String city;

  private String postalCode;

  private String street;

  private String number;

  private Set<String> coverages;
}
