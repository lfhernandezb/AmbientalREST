package cl.dsoft.ambiental.domain.service;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.domain.dto.ProjectDTO;
import cl.dsoft.ambiental.persistance.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDTOService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDTO> getAll() {
        return projectRepository.getAll();
    }

    public Optional<ProjectDTO> getProject(long projectId) {
        return projectRepository.getProject(projectId);
    }

    public Optional<List<ProjectDTO>> getByDescriptionAndCompanyId(String description, long companyId) {
        return projectRepository.findByDescriptionAndCompanyId(description, companyId);
    }

    public Optional<List<ProjectDTO>> getByDescriptionContainingIgnoreCaseAndCompanyId(String description, long companyId) {
        return projectRepository.findByDescriptionContainingIgnoreCaseAndCompanyId(description, companyId);
    }

    public Optional<List<ProjectDTO>> getByCompanyId(long companyId) {
        return projectRepository.findByCompanyId(companyId);
    }

    public ProjectDTO save(ProjectDTO project) {
        // valido que ya no exista una compania con el mismo nombre
        if (projectRepository.findByDescriptionAndCompanyId(project.getDescription(), project.getCompanyId()).isPresent()) {
            return null;
        }
        return projectRepository.save(project);
    }

    public ProjectDTO update(ProjectDTO project) {
        // valido que exista el proyecto
        Optional<ProjectDTO> projectDTO = projectRepository.getProject(project.getProjectId());
        if (projectDTO.isPresent()) {
            projectDTO.map((proj) -> {
                proj.setDescription(project.getDescription());
                proj.setAddress(project.getAddress());
                projectRepository.save(proj);
                return proj;
            });
        }
        return null;
    }

    public boolean delete(long projectId) {
        try {
            projectRepository.delete(projectId);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
