package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.persistance.crud.CompanyCrudRepository;
import cl.dsoft.ambiental.persistance.entity.Company;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class CompanyCrudRepositoryTest {

    @Autowired
    private CompanyCrudRepository companyCrudRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Order(2)
    public void getAll() {
        assertTrue(companyCrudRepository.count()> 0);
    }
    /*
    @Test
    public void getCompany() {
        assertTrue(companyDTOService.getCompany(3).isPresent());
    }

    @Test
    public void getByName() {
        assertTrue(companyDTOService.getByName("Company 1").isPresent());
    }
    */

    @Test
    @Ignore
    @Order(1)
    @Rollback(value = true)
    public void saveCompanyTest() {
        Company company = Company.builder()
                        .name("Company_B")
                                .build();

        Assertions.assertThat(companyCrudRepository.save(company).getId()).isEqualTo(13L);
        //assertTrue(companyDTOService.save(companyDTO) != null);
    }

    @Test
    @Ignore
    @Order(3)
    public void updateCompanyTest() {
        Optional<Company> company = companyCrudRepository.findById(13L);

        assertTrue(company.isPresent());

        Optional<Company> company2 = company.map((comp) -> {
            comp.setName("Company_X");
            return companyCrudRepository.save(comp);
        });

        assertTrue(company2.isPresent());
        assertTrue(company2.map((comp) -> {
           return comp;
        }).get().getName().equals("Company_X"));
    }

    @Test
    @Ignore
    @Order(4)
    public void deleteCompanyTest() {
        companyCrudRepository.deleteById(13L);

        assertTrue(!companyCrudRepository.findById(13L).isPresent());
    }
}