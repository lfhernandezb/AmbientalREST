package cl.dsoft.ambiental.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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
@Table(name = "findings")
public class Finding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_finding")
    private long id;
    private String identifier;
    private String description;
    private String comment;
    @Column(name = "id_finding_state")
    private int idFindingState;

    /*
    @OneToOne
    @JoinColumn(name = "id_finding_state", insertable = false, updatable = false)
    private FindingState findingState;
    */
    private String image;
    @Column(name = "id_project")
    private long idProject;

    /*
    @ManyToOne
    @JoinColumn(name = "id_project", insertable = false, updatable = false)
    private Project project;
    */

    private Date date;

    /*
    public FindingState getFindingState() {
        return findingState;
    }

    public void setFindingState(FindingState findingState) {
        this.findingState = findingState;
    }
    */
    /*
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    */
}