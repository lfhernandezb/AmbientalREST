package cl.dsoft.ambiental.domain.repository;

import cl.dsoft.ambiental.domain.dto.ProjectDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectDTORepository {
    List<ProjectDTO> getAll();
    Optional<List<ProjectDTO>> findByDescriptionAndCompanyId(String description, long idCompany);
    Optional<List<ProjectDTO>> findByCompanyId(long projectId);
    Optional<ProjectDTO> getProject(long projectId);
    ProjectDTO save(ProjectDTO project);
    void delete(long projectId);
}
