package cl.dsoft.ambiental.domain.repository;

import cl.dsoft.ambiental.domain.dto.ProjectDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectDTORepository {
    List<ProjectDTO> getAll();
    Optional<List<ProjectDTO>> findByDescription(String name);
    Optional<List<ProjectDTO>> findByCompanyId(long companyId);
    Optional<ProjectDTO> getProject(long projectId);
    ProjectDTO save(ProjectDTO project);
    void delete(long projectId);
}
