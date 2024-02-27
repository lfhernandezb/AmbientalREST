package cl.dsoft.ambiental.web.controller;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.domain.service.CompanyDTOService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class CompanyControllerTest {

    @Autowired
    private CompanyDTOService companyDTOService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() {
        assertTrue(companyDTOService.getAll().size() > 0);
    }

    @Test
    public void getCompany() {
        assertTrue(companyDTOService.getCompany(3).isPresent());
    }

    @Test
    public void getByName() {
        assertTrue(companyDTOService.getByName("Company 1").isPresent());
    }

    @Test
    public void save() {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName("Company 1");
        CompanyDTO companyDTO2 = companyDTOService.save(companyDTO);
        assertTrue(companyDTO2 != null);
    }

    @Test
    public void delete() {
        assertTrue(companyDTOService.delete(2));
    }
}