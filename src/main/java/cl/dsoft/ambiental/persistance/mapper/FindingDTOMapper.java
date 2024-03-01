package cl.dsoft.ambiental.persistance.mapper;

import cl.dsoft.ambiental.domain.dto.FindingDTO;
import cl.dsoft.ambiental.persistance.entity.Finding;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FindingStateDTOMapper.class, ProjectDTOMapper.class})
public interface FindingDTOMapper {
    @Mappings({
            @Mapping(source = "id", target = "findingId"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "idFindingState", target = "findingStateId"),
            //@Mapping(source = "findingState", target = "findingState"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "idProject", target = "projectId"),
            //@Mapping(source = "project", target = "project")
    })
    FindingDTO toFindingDTO(Finding finding);
    List<FindingDTO> toFindingDTOs(List<Finding> finding);

    @InheritInverseConfiguration
        // @Mapping(target = "codigoBarras", ignore = true)
    Finding toFinding(FindingDTO finding);

}
