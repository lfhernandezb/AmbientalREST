package cl.dsoft.ambiental.domain.service;

import cl.dsoft.ambiental.domain.dto.FindingDTO;
import cl.dsoft.ambiental.persistance.FindingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindingDTOService {

    @Autowired
    private FindingRepository findingRepository;

    public List<FindingDTO> getAll() {
        return findingRepository.getAll();
    }

    public Optional<FindingDTO> getFinding(long findingId) {
        return findingRepository.getFinding(findingId);
    }

    public Optional<List<FindingDTO>> getByProjectId(long projectId) {
        return findingRepository.findByProjectId(projectId);
    }

    public Optional<List<FindingDTO>> getByIdentifierAndProjectId(String description, long projectId) {
        return findingRepository.findByIdentifierAndProjectId(description, projectId);
    }

    public Optional<List<FindingDTO>> getByDescriptionAndProjectId(String description, long projectId) {
        return findingRepository.findByDescriptionAndProjectId(description, projectId);
    }

    public Optional<List<FindingDTO>> getByDescriptionContainingIgnoreCaseAndProjectId(String description, long projectId) {
        return findingRepository.findByDescriptionContainingIgnoreCaseAndProjectId(description, projectId);
    }

    public FindingDTO save(FindingDTO finding) {
        // valido que ya no exista un hallazgo con el mismo identifier e idProject
        if (findingRepository.findByIdentifierAndProjectId(finding.getIdentifier(), finding.getProjectId()).isPresent()) {
            return null;
        }
        return findingRepository.save(finding);
    }

    public FindingDTO update(FindingDTO finding) {
        // valido que exista el proyecto
        Optional<FindingDTO> findingDTO = findingRepository.getFinding(finding.getFindingId());
        if (findingDTO.isPresent()) {
            findingDTO.map((find) -> {
                find.setIdentifier(finding.getIdentifier());
                find.setDescription(finding.getDescription());
                find.setComment(finding.getComment());
                find.setFindingStateId(finding.getFindingStateId());
                find.setImage(finding.getImage());
                find.setDate(finding.getDate());
                findingRepository.save(find);
                return find;
            });
        }
        return null;
    }

    public boolean delete(long findingId) {
        try {
            findingRepository.delete(findingId);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
