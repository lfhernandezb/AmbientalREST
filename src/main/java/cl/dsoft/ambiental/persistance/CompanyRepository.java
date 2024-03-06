package cl.dsoft.ambiental.persistance;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.domain.repository.CompanyDTORepository;
import cl.dsoft.ambiental.persistance.crud.CompanyCrudRepository;
import cl.dsoft.ambiental.persistance.entity.Company;
import cl.dsoft.ambiental.persistance.mapper.CompanyDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepository implements CompanyDTORepository {
    @Autowired
    private CompanyCrudRepository companyCrudRepository;

    @Autowired
    private CompanyDTOMapper companyDTOMapper;

    @Override
    public List<CompanyDTO> getAll() {
        List<Company> companies = (List<Company>) companyCrudRepository.findAll();
        return companyDTOMapper.toCompanyDTOs(companies);
    }

    @Override
    public Optional<List<CompanyDTO>> findByName(String name) {
        Optional<List<Company>> companies = companyCrudRepository.findByName(name);
        return companies.map((comps) -> companyDTOMapper.toCompanyDTOs(comps));
    }

    @Override
    public Optional<List<CompanyDTO>> findByNameContainingIgnoreCase(String name) {
        Optional<List<Company>> companies = companyCrudRepository.findByNameContainingIgnoreCase(name);
        return companies.map((comps) -> companyDTOMapper.toCompanyDTOs(comps));
    }

    @Override
    public Optional<CompanyDTO> getCompany(long companyId) {
        return companyCrudRepository.findById(companyId).map((company) ->
            companyDTOMapper.toCompanyDTO(company)
        );
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = companyDTOMapper.toCompany(companyDTO);
        return companyDTOMapper.toCompanyDTO(companyCrudRepository.save(company));
    }
    /*
    @Override
    public CompanyDTO update(CompanyDTO companyDTO) {
        Company company = companyDTOMapper.toCompany(companyDTO);
        return companyDTOMapper.toCompanyDTO(companyCrudRepository.save(company));
    }
    */
    @Override
    public void delete(long companyId) {
        companyCrudRepository.deleteById(companyId);
    }

    public Optional<Company> getById(long id) {
        return companyCrudRepository.findById(id);
    }

    public Company create(Company company) {
        return companyCrudRepository.save(company);
    }

    //@Query(value = "SELECT * FROM companies c WHERE c.name = :name",
    //        nativeQuery = true)
    public Optional<List<Company>> getAllByName(@Param("name") String name) {
        return companyCrudRepository.findByName(name);
    }
}
