package es.urjc.cloudapps.insurancecompany.clients.infrastructure;

import es.urjc.cloudapps.insurancecompany.clients.application.create.CreateClientCommand;
import es.urjc.cloudapps.insurancecompany.clients.domain.Client;
import es.urjc.cloudapps.insurancecompany.clients.infrastructure.h2.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientMapper {

    @Mapping(target = "id", source = "client.id.id")
    @Mapping(target = "name", source = "client.name")
    @Mapping(target = "surname", source = "client.surname")
    @Mapping(target = "country", source = "client.address.country")
    @Mapping(target = "city", source = "client.address.city")
    @Mapping(target = "postalCode", source = "client.address.postalCode")
    @Mapping(target = "street", source = "client.address.street")
    @Mapping(target = "number", source = "client.address.number")
    ClientEntity clientToClientEntity(Client client);

    @Mapping(target = "id", source = "client.id.id")
    @Mapping(target = "name", source = "client.name")
    @Mapping(target = "surname", source = "client.surname")
    @Mapping(target = "country", source = "client.address.country")
    @Mapping(target = "city", source = "client.address.city")
    @Mapping(target = "postalCode", source = "client.address.postalCode")
    @Mapping(target = "street", source = "client.address.street")
    @Mapping(target = "number", source = "client.address.number")
    ClientDTO clientToClientDto(Client client);

    CreateClientCommand clientDtoToClientCommand(ClientDTO clientDTO);
}
