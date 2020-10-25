package es.urjc.cloudapps.insurancecompany.incidences.shared;

import es.urjc.cloudapps.insurancecompany.incidences.application.create.CreateIncidenceCommand;
import es.urjc.cloudapps.insurancecompany.incidences.application.find.IncidenceFinderResponse;
import es.urjc.cloudapps.insurancecompany.incidences.domain.Incidence;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceId;
import es.urjc.cloudapps.insurancecompany.incidences.domain.IncidenceStatus;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.http.IncidenceDto;
import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres.IncidenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.money.CurrencyUnit;

@Mapper
public interface IncidenceMapper {

    CreateIncidenceCommand incidenceDTOtoIncidenceCommand(IncidenceDto dto);

    @Mapping(target = "id", source = "incidence.id")
    @Mapping(target = "insuranceId", source = "incidence.insuranceId.id")
    @Mapping(target = "date", source = "incidence.date")
    @Mapping(target = "incidenceType", source = "incidence.coverageIncidence.id.id")
    @Mapping(target = "description", source = "incidence.description")
    @Mapping(target = "amount", source = "incidence.amount.amount")
    @Mapping(target = "currency", source = "incidence.amount.currency")
    @Mapping(target = "status", source = "incidence.status")
    IncidenceDto incidenceToIncidenceDTO(Incidence incidence);

    @Mapping(target = "id", source = "incidence.id")
    @Mapping(target = "insurance.id", source = "incidence.insuranceId.id")
    @Mapping(target = "date", source = "incidence.date")
    @Mapping(target = "type", source = "incidence.coverageIncidence.id.id")
    @Mapping(target = "description", source = "incidence.description")
    @Mapping(target = "amount", source = "incidence.amount.amount")
    @Mapping(target = "currency", source = "incidence.amount.currency")
    @Mapping(target = "status", source = "incidence.status")
    IncidenceEntity incidenceToIncidenceEntity(Incidence incidence);

    IncidenceDto incidenceFinderResponseToIncidenceDto(IncidenceFinderResponse incidenceFinderResponse);

    default String incidenceStatusToString(IncidenceStatus incidenceStatus) {
        return incidenceStatus.name();
    }

    default String currencyToString(CurrencyUnit currency) {
        return currency.getCurrencyCode();
    }

    default String incidenceIdtoString(IncidenceId incidenceId) {
        return incidenceId.getId();
    }
}
