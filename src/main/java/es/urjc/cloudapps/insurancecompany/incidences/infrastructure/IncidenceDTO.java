package es.urjc.cloudapps.insurancecompany.incidences.infrastructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class IncidenceDTO {

    private String id;

    private String insuranceId;

    private LocalDateTime date;

    private String incidenceType;

    private String description;

    private BigDecimal amount;

    private String currency;

    private String status;

}
