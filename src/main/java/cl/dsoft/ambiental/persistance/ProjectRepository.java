package cl.dsoft.ambiental.persistance;

import cl.dsoft.ambiental.domain.dto.ProjectDTO;
import cl.dsoft.ambiental.domain.repository.ProjectDTORepository;
import cl.dsoft.ambiental.persistance.crud.ProjectCrudRepository;
import cl.dsoft.ambiental.persistance.crud.ProjectCrudRepository;
import cl.dsoft.ambiental.persistance.entity.Project;
import cl.dsoft.ambiental.persistance.mapper.ProjectDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository implements ProjectDTORepository {
    @Autowired
    private ProjectCrudRepository projectCrudRepository;

    @Autowired
    private ProjectDTOMapper projectDTOMapper;

    @Override
    public List<ProjectDTO> getAll() {
        List<Project> companies = (List<Project>) projectCrudRepository.findAll();
        return projectDTOMapper.toProjectDTOs(companies);
    }

    @Override
    public Optional<List<ProjectDTO>> findByDescriptionAndCompanyId(String description, long companyId) {
        Optional<List<Project>> companies = projectCrudRepository.findByDescriptionAndIdCompany(description, companyId);
        return companies.map((comps) -> projectDTOMapper.toProjectDTOs(comps));
    }

    @Override
    public Optional<List<ProjectDTO>> findByCompanyId(long companyId) {
        Optional<List<Project>> projects = projectCrudRepository.findByIdCompany(companyId);
        return projects.map((projs) -> projectDTOMapper.toProjectDTOs(projs));
    }

    @Override
    public Optional<ProjectDTO> getProject(long projectId) {
        return projectCrudRepository.findById(projectId).map((project) ->
                projectDTOMapper.toProjectDTO(project)
        );
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        Project project = projectDTOMapper.toProject(projectDTO);
        return projectDTOMapper.toProjectDTO(projectCrudRepository.save(project));
    }
    /*
    @Override
    public ProjectDTO update(ProjectDTO projectDTO) {
        if (projectCrudRepository.findByDescription(projectDTO.getDescription()).isPresent()) {
            return null;
        }
        Project project = projectDTOMapper.toProject(projectDTO);
        return projectDTOMapper.toProjectDTO(projectCrudRepository.save(project));
    }
    */
    @Override
    public void delete(long projectId) {
        projectCrudRepository.deleteById(projectId);
    }

    public Optional<Project> getById(long id) {
        return projectCrudRepository.findById(id);
    }

    public Project create(Project project) {
        return projectCrudRepository.save(project);
    }
    /*
    //@Query(value = "SELECT * FROM projects p WHERE p.description = :description",
    //        nativeQuery = true)
    public Optional<List<Project>> getAllByDescription(@Param("description") String description) {
        return projectCrudRepository.findByDescription(description);
    }
    */
}
