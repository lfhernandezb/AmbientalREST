package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.persistance.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyCrudRepository extends CrudRepository<Company, Long> {
    Optional<List<Company>> findByName(String name);
    Optional<List<Company>> findByNameContainingIgnoreCase(String name);
}
