package es.urjc.cloudapps.insurancecompany.incidences.application.create;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
