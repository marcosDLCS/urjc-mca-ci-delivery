package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.shared;

import es.urjc.cloudapps.insurancecompany.insurances.application.create.CreateInsuranceCommand;
import es.urjc.cloudapps.insurancecompany.insurances.domain.Insurance;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.http.InsuranceDTO;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres.InsuranceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CoverageMapper.class)
public interface InsuranceMapper {

    @Mapping(target = "clientId", source = "insurance.clientId")
    @Mapping(target = "houseRegistry", source = "insurance.house.registry")
    @Mapping(target = "houseCountry", source = "insurance.house.country")
    @Mapping(target = "houseCity", source = "insurance.house.city")
    @Mapping(target = "housePostalCode", source = "insurance.house.postalCode")
    @Mapping(target = "houseStreet", source = "insurance.house.street")
    @Mapping(target = "houseNumber", source = "insurance.house.number")
    @Mapping(target = "coverages", source = "insurance.coverages")
    CreateInsuranceCommand insuranceDtoToInsuranceCommand(InsuranceDTO insurance);

    @Mapping(target = "id", source = "insurance.id.id")
    @Mapping(target = "client.id", source = "insurance.clientId.id")
    @Mapping(target = "houseRegistry", source = "insurance.house.registry.registry")
    @Mapping(target = "houseCountry", source = "insurance.house.address.country")
    @Mapping(target = "houseCity", source = "insurance.house.address.city")
    @Mapping(target = "housePostalCode", source = "insurance.house.address.postalCode")
    @Mapping(target = "houseStreet", source = "insurance.house.address.street")
    @Mapping(target = "houseNumber", source = "insurance.house.address.number")
    @Mapping(target = "coverages", source = "insurance.coverages")
    InsuranceEntity insuranceToInsuranceEntity(Insurance insurance);

    @Mapping(target = "id", source = "insurance.id.id")
    @Mapping(target = "clientId", source = "insurance.clientId.id")
    @Mapping(target = "house.registry", source = "insurance.house.registry.registry")
    @Mapping(target = "house.country", source = "insurance.house.address.country")
    @Mapping(target = "house.city", source = "insurance.house.address.city")
    @Mapping(target = "house.postalCode", source = "insurance.house.address.postalCode")
    @Mapping(target = "house.street", source = "insurance.house.address.street")
    @Mapping(target = "house.number", source = "insurance.house.address.number")
    @Mapping(target = "coverages", source = "insurance.coverages")
    InsuranceDTO insuranceToInsuranceDto(Insurance insurance);
}
