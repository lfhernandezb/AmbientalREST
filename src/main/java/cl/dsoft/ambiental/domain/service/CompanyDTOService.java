package cl.dsoft.ambiental.domain.service;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.persistance.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CompanyDTOService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyDTO> getAll() {

        return companyRepository.getAll();
    }

    public Optional<CompanyDTO> getCompany(long companyId) {

        return companyRepository.getCompany(companyId);
    }

    public Optional<List<CompanyDTO>> getByName(String name) {

        return companyRepository.findByName(name);
    }

    public Optional<List<CompanyDTO>> getByNameContaining(String name) {
        return companyRepository.findByNameContainingIgnoreCase(name);
    }

    public CompanyDTO save(CompanyDTO company) {
        // valido que ya no exista una compania con el mismo nombre
        if (companyRepository.getAllByName(company.getName()).isPresent() && company.getCompanyId() < 1) {
            return null;
        }
        return companyRepository.save(company);
    }

    public CompanyDTO update(CompanyDTO company) {
        // valido que exista la compania
        Optional<CompanyDTO> companyDTO = companyRepository.getCompany(company.getCompanyId());
        if (companyDTO.isPresent()) {
            companyDTO.map((comp) -> {
                comp.setName(company.getName());
                companyRepository.save(comp);
                return comp;
            });
        }
        return null;
    }

    public boolean delete(long companyId) {
        try {
            companyRepository.delete(companyId);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
