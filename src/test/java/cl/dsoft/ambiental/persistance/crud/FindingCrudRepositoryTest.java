package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.persistance.entity.Finding;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class FindingCrudRepositoryTest {

    @Autowired
    private FindingCrudRepository findingCrudRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Order(2)
    public void getAll() {
        assertTrue(findingCrudRepository.count() > 0);
    }

    @Test
    public void getFinding() {
        assertTrue(findingCrudRepository.findById(3L).isPresent());
    }

    @Test
    public void getByProject() {
        assertTrue(findingCrudRepository.findByIdProject(1L).isPresent());
    }
    /*
    @Test
    public void getFindingByDescriptionAndCompanyId() {
        assertTrue(findingCrudRepository.findByDescriptionAndIdCompany("Finding_1Ay", 3L).isPresent());
    }
    */
    @Test
    @Ignore
    @Order(1)
    public void save() {
        Finding finding = Finding.builder()
                .identifier("Finding_1A_A1")
                .description("Description 1A_A1")
                .comment("Description 1A_A1")
                .idFindingState(1)
                .image("")
                .idProject(1)
                .date(new Date())
                .build();

        assertTrue(findingCrudRepository.save(finding) != null);

    }

    @Test
    @Ignore
    @Order(3)
    public void update() {
        Optional<Finding> finding = findingCrudRepository.findById(3L);

        assertTrue(finding.isPresent());

        Optional<Finding> finding2 = finding.map((find) -> {
            find.setIdentifier("Finding_1A_A1x");
            find.setDescription("Description 1A_A1x");
            find.setComment("Comment 1A_A1x");
            find.setIdFindingState(2);
            find.setImage("hola");
            find.setDate(new Date());
            return findingCrudRepository.save(find);
        });

        assertTrue(finding2.isPresent());
        assertTrue(finding2.map((comp) -> {
            return comp;
        }).get().getIdentifier().equals("Finding_1A_A1x"));
    }


    @Test
    @Ignore
    @Order(4)
    public void delete() {
        findingCrudRepository.deleteById(2L);

        assertFalse(findingCrudRepository.findById(2L).isPresent());
    }


}
