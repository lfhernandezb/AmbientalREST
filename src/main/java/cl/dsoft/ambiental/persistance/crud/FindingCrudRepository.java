package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.persistance.entity.Finding;
import cl.dsoft.ambiental.persistance.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FindingCrudRepository extends CrudRepository<Finding, Long> {
    Optional<List<Finding>> findByIdProject(long idProject);
    Optional<List<Finding>> findByIdentifierAndIdProject(String identifier, long idProject);

}
