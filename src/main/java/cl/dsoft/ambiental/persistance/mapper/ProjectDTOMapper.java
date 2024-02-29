package cl.dsoft.ambiental.persistance.mapper;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.domain.dto.ProjectDTO;
import cl.dsoft.ambiental.persistance.entity.Company;
import cl.dsoft.ambiental.persistance.entity.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CompanyDTOMapper.class})
public interface ProjectDTOMapper {
    @Mappings({
            @Mapping(source = "id", target = "projectId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "idCompany", target = "companyId"),
            //@Mapping(source = "company", target = "company"),
    })
    ProjectDTO toProjectDTO(Project project);
    List<ProjectDTO> toProjectDTOs(List<Project> projects);

    @InheritInverseConfiguration
        // @Mapping(target = "codigoBarras", ignore = true)
    Project toProject(ProjectDTO project);

}
