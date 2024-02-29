package cl.dsoft.ambiental.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*
The annotations used are:
@Data: This annotation is from the Lombok library and is used to automatically generate getters and setters for all fields in the class, as well as implementations of toString(), equals(), and hashCode(). This reduces the amount of boilerplate code that needs to be written.

@AllArgsConstructor: This annotation is also from Lombok and generates a constructor that takes all of the fields in the class as arguments.

@NoArgsConstructor: This annotation is also from Lombok and generates a no-argument constructor.

@Builder: This annotation is also from Lombok and generates a builder pattern for the class, which provides a convenient way to create instances of the class with default or optional values for some fields.

@Entity: This annotation is from the Java Persistence API (JPA) and marks the class as an entity that can be persisted to a database.

@Table(name = "employees"): This annotation specifies the name of the table that corresponds to this entity in the database.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    /*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private List<Finding> findings;
    */
    /*
    @ManyToOne
    @JoinColumn(name = "id_company", insertable = false, updatable = false)
    private Company company;
    */

    /*
    public List<Finding> getFindings() {
        return findings;
    }

    public void setFindings(List<Finding> findings) {
        this.findings = findings;
    }
    */
    /*
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    */
}
