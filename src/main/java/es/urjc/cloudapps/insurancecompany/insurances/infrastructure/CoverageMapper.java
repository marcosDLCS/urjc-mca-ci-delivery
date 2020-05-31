package es.urjc.cloudapps.insurancecompany.insurances.infrastructure;

import es.urjc.cloudapps.insurancecompany.insurances.domain.Coverage;
import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2.CoverageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CoverageMapper {

    @Mapping(target = "id", source = "coverage.name")
    CoverageEntity coverageToCoverageEntity(Coverage coverage);

    default String coverageToCoverageString(Coverage coverage) {
        return coverage.getName();
    }

}
