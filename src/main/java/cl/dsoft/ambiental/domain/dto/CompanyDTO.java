package cl.dsoft.ambiental.domain.dto;

import cl.dsoft.ambiental.persistance.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {
    private long CompanyId;
    private String name;
    //private List<ProjectDTO> projects;

    /*
    public long getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(long companyId) {
        CompanyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
    */
}
