package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.persistance.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectCrudRepository extends CrudRepository<Project, Long> {
}
