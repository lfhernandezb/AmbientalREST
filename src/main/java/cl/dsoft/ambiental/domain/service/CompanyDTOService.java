package cl.dsoft.ambiental.domain.service;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.domain.repository.CompanyDTORepository;
import cl.dsoft.ambiental.persistance.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public CompanyDTO save(CompanyDTO company) {
        System.out.println("CompanyDTOService::save");
        return companyRepository.save(company);
    }

    public boolean delete(long productId) {
        System.out.println("CompanyDTOService::delete");
        try {
            companyRepository.delete(productId);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
