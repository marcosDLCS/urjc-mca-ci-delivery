package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IncidenceDto {

  private String id;

  private String insuranceId;

  private LocalDateTime date;

  private String incidenceType;

  private String description;

  private BigDecimal amount;

  private String currency;

  private String status;
}
