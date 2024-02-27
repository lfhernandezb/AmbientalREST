package cl.dsoft.ambiental.persistance.mapper;

import cl.dsoft.ambiental.domain.dto.FindingDTO;
import cl.dsoft.ambiental.domain.dto.FindingStateDTO;
import cl.dsoft.ambiental.persistance.entity.Finding;
import cl.dsoft.ambiental.persistance.entity.FindingState;
import cl.dsoft.ambiental.persistance.entity.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FindingStateDTOMapper {
    @Mappings({
            @Mapping(source = "id", target = "findingStateId"),
            @Mapping(source = "description", target = "description"),
    })
    FindingStateDTO toFindingStateDTO(FindingState findingState);
    List<FindingStateDTO> toFindingStateDTOs(List<FindingState> findingStates);

    @InheritInverseConfiguration
        // @Mapping(target = "codigoBarras", ignore = true)
    FindingState toFindingState(FindingStateDTO findingState);

}
