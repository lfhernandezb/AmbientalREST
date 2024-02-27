package cl.dsoft.ambiental.persistance.mapper;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.persistance.entity.Company;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProjectDTOMapper.class})
public interface CompanyDTOMapper {
    @Mappings({
            @Mapping(source = "id", target = "companyId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "projects", target = "projects")
    })
    CompanyDTO toCompanyDTO(Company company);
    List<CompanyDTO> toCompanyDTOs(List<Company> companies);

    @InheritInverseConfiguration
    // @Mapping(target = "codigoBarras", ignore = true)
    Company toCompany(CompanyDTO product);
}
