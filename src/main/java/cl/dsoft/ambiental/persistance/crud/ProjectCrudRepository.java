package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.persistance.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectCrudRepository extends CrudRepository<Project, Long> {
    Optional<List<Project>> findByDescriptionAndIdCompany(String description, long idCompany);
    Optional<List<Project>> findByDescriptionContainingIgnoreCaseAndIdCompany(String description, long idCompany);
    Optional<List<Project>> findByIdCompany(long idCompany);
}
