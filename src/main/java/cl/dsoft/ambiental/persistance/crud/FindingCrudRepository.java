package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.persistance.entity.Finding;
import org.springframework.data.repository.CrudRepository;

public interface FindingCrudRepository extends CrudRepository<Finding, Long> {
}
