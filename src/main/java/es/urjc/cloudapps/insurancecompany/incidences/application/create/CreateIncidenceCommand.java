package es.urjc.cloudapps.insurancecompany.incidences.application.create;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateIncidenceCommand {

  private String id;

  private String insuranceId;

  private String incidenceType;

  private String description;

  private BigDecimal amount;

  private String currency;

  private String status;
}
