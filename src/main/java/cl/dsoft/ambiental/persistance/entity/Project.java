package cl.dsoft.ambiental.persistance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private long id;
    private String description;
    private String address;
    @Column(name = "id_company")
    private long idCompany;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private List<Finding> findings;

    @ManyToOne
    @JoinColumn(name = "id_company", insertable = false, updatable = false)
    private Company company;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getIdCompany() {
        return this.idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }
    public List<Finding> getFindings() {
        return findings;
    }

    public void setFindings(List<Finding> findings) {
        this.findings = findings;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
