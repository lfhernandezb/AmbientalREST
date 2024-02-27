package cl.dsoft.ambiental.persistance.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "id_finding_state", insertable = false, updatable = false)
    private FindingState findingState;

    private String image;
    @Column(name = "id_project")
    private long idProject;
    @ManyToOne
    @JoinColumn(name = "id_project", insertable = false, updatable = false)
    private Project project;

    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public FindingState getFindingState() {
        return findingState;
    }

    public void setFindingState(FindingState findingState) {
        this.findingState = findingState;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdFindingState() {
        return idFindingState;
    }

    public void setIdFindingState(int idFindingState) {
        this.idFindingState = idFindingState;
    }

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }
}