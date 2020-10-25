package es.urjc.cloudapps.insurancecompany.incidences.application.find;

import lombok.Data;

import javax.money.CurrencyUnit;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class IncidenceFinderResponse {

    private final String id;

    private final String insuranceId;

    private final LocalDateTime date;

    private final String description;

    private final String coverageIncidence;

    private final BigDecimal amount;

    private final CurrencyUnit currency;

    private String status;
}
