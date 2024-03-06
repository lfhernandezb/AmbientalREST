package cl.dsoft.ambiental.domain.repository;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CompanyDTORepository {
    List<CompanyDTO> getAll();
    Optional<List<CompanyDTO>> findByName(String name);
    Optional<List<CompanyDTO>> findByNameContainingIgnoreCase(String name);
    Optional<CompanyDTO> getCompany(long CompanyId);
    CompanyDTO save(CompanyDTO Company);
    void delete(long CompanyId);
}
