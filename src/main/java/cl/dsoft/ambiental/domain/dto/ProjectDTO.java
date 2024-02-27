package cl.dsoft.ambiental.domain.dto;

import cl.dsoft.ambiental.persistance.entity.Company;
import cl.dsoft.ambiental.persistance.entity.Finding;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class ProjectDTO {
    private long projectId;
    private String description;
    private String address;
    private long companyId;
    private List<FindingDTO> findings;
    private CompanyDTO company;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public List<FindingDTO> getFindings() {
        return findings;
    }

    public void setFindings(List<FindingDTO> findings) {
        this.findings = findings;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
