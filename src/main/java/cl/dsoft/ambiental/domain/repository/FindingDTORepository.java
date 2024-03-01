package cl.dsoft.ambiental.domain.repository;

import cl.dsoft.ambiental.domain.dto.FindingDTO;

import java.util.List;
import java.util.Optional;

public interface FindingDTORepository {
    List<FindingDTO> getAll();
    Optional<List<FindingDTO>> findByProjectId(long projectId);
    Optional<FindingDTO> getFinding(long findingId);
    public Optional<List<FindingDTO>> findByIdentifierAndProjectId(String description, long projectId);
    FindingDTO save(FindingDTO finding);
    void delete(long findingId);
}
