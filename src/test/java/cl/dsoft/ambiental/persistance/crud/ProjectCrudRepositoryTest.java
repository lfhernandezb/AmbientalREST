package cl.dsoft.ambiental.persistance.crud;

import cl.dsoft.ambiental.persistance.entity.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class ProjectCrudRepositoryTest {

    @Autowired
    private ProjectCrudRepository projectCrudRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Order(2)
    public void getAll() {
        assertTrue(projectCrudRepository.count() > 0);
    }

    @Test
    public void getProject() {
        assertTrue(projectCrudRepository.findById(1L).isPresent());
    }

    @Test
    public void getByCompany() {
        assertTrue(projectCrudRepository.findByIdCompany(3L).isPresent());
    }

    @Test
    public void getProjectByDescriptionAndCompanyId() {
        assertTrue(projectCrudRepository.findByDescriptionAndIdCompany("Project_1Ay", 3L).isPresent());
    }

    @Test
    @Ignore
    @Order(1)
    public void save() {
        Project project = Project.builder()
                .description("Project_B1")
                .address("Street B1 #1234")
                .idCompany(3)
                        .build();

        assertTrue(projectCrudRepository.save(project) != null);

    }

    @Test
    @Order(3)
    public void update() {
        Optional<Project> project = projectCrudRepository.findById(1L);

        assertTrue(project.isPresent());

        Optional<Project> project2 = project.map((comp) -> {
            comp.setDescription("Project_1Ay");
            return projectCrudRepository.save(comp);
        });

        assertTrue(project2.isPresent());
        assertTrue(project2.map((comp) -> {
            return comp;
        }).get().getDescription().equals("Project_1Ay"));
    }


    @Test
    @Ignore
    @Order(4)
    public void delete() {
        projectCrudRepository.deleteById(3L);

        assertFalse(projectCrudRepository.findById(3L).isPresent());
    }

}