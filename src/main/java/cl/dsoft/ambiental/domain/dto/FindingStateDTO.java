package cl.dsoft.ambiental.domain.dto;

public class FindingStateDTO {
    private int findingStateId;
    private String description;

    public int getFindingStateId() {
        return findingStateId;
    }

    public void setFindingStateId(int findingStateId) {
        this.findingStateId = findingStateId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
