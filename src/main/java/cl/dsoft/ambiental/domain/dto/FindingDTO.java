package cl.dsoft.ambiental.domain.dto;

import cl.dsoft.ambiental.persistance.entity.Company;
import cl.dsoft.ambiental.persistance.entity.Finding;
import cl.dsoft.ambiental.persistance.entity.FindingState;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class FindingDTO {
    private long findingId;
    private String identifier;
    private String description;
    private String comment;
    private int findingStateId;
    private FindingStateDTO findingState;
    private String image;
    private long projectId;
    private ProjectDTO project;
    private Date date;

    public long getFindingId() {
        return findingId;
    }

    public void setFindingId(long findingId) {
        this.findingId = findingId;
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

    public int getFindingStateId() {
        return findingStateId;
    }

    public void setFindingStateId(int findingStateId) {
        this.findingStateId = findingStateId;
    }

    public FindingStateDTO getFindingState() {
        return findingState;
    }

    public void setFindingState(FindingStateDTO findingState) {
        this.findingState = findingState;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
