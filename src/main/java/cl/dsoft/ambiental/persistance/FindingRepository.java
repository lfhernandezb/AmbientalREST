package cl.dsoft.ambiental.persistance;

import cl.dsoft.ambiental.domain.dto.FindingDTO;
import cl.dsoft.ambiental.domain.repository.FindingDTORepository;
import cl.dsoft.ambiental.persistance.crud.FindingCrudRepository;
import cl.dsoft.ambiental.persistance.entity.Finding;
import cl.dsoft.ambiental.persistance.mapper.FindingDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FindingRepository implements FindingDTORepository {

    @Autowired
    private FindingCrudRepository findingCrudRepository;

    @Autowired
    private FindingDTOMapper findingDTOMapper;

    @Override
    public List<FindingDTO> getAll() {
        List<Finding> companies = (List<Finding>) findingCrudRepository.findAll();
        return findingDTOMapper.toFindingDTOs(companies);
    }

    @Override
    public Optional<List<FindingDTO>> findByProjectId(long projectId) {
        Optional<List<Finding>> findings = findingCrudRepository.findByIdProject(projectId);
        return findings.map((finds) -> findingDTOMapper.toFindingDTOs(finds));
    }

    @Override
    public Optional<FindingDTO> getFinding(long findingId) {
        return findingCrudRepository.findById(findingId).map((finding) ->
                findingDTOMapper.toFindingDTO(finding)
        );
    }

    @Override
    public Optional<List<FindingDTO>> findByDescriptionAndProjectId(String description, long projectId) {
        Optional<List<Finding>> companies = findingCrudRepository.findByDescriptionContainingIgnoreCaseAndIdProject(description, projectId);
        return companies.map((finds) -> findingDTOMapper.toFindingDTOs(finds));
    }

    @Override
    public Optional<List<FindingDTO>> findByDescriptionContainingIgnoreCaseAndProjectId(String description, long projectId) {
        Optional<List<Finding>> companies = findingCrudRepository.findByDescriptionContainingIgnoreCaseAndIdProject(description, projectId);
        return companies.map((finds) -> findingDTOMapper.toFindingDTOs(finds));
    }

    @Override
    public Optional<List<FindingDTO>> findByIdentifierAndProjectId(String description, long projectId) {
        Optional<List<Finding>> companies = findingCrudRepository.findByIdentifierAndIdProject(description, projectId);
        return companies.map((finds) -> findingDTOMapper.toFindingDTOs(finds));
    }

    @Override
    public FindingDTO save(FindingDTO findingDTO) {
        Finding finding = findingDTOMapper.toFinding(findingDTO);
        return findingDTOMapper.toFindingDTO(findingCrudRepository.save(finding));
    }
    @Override
    public void delete(long findingId) {
        findingCrudRepository.deleteById(findingId);
    }

    public Optional<Finding> getById(long id) {
        return findingCrudRepository.findById(id);
    }

    public Finding create(Finding finding) {
        return findingCrudRepository.save(finding);
    }

}
