package cl.dsoft.ambiental.web.controller;

import cl.dsoft.ambiental.domain.dto.ProjectDTO;
import cl.dsoft.ambiental.domain.service.ProjectDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectDTOService projectDTOService;

    @GetMapping("/all")
    //@ApiOperation("Get all supermarket products")
    //@ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ProjectDTO>> getAll() {
        return new ResponseEntity<List<ProjectDTO>>(projectDTOService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    //@ApiOperation("Search a product with an ID")
    //@ApiResponses({
    //@ApiResponse(code = 200, message = "OK"),
    //@ApiResponse(code = 404, message = "Product not found"),     })
    public ResponseEntity<ProjectDTO> getProject(@PathVariable("id") long projectId) {
        return projectDTOService.getProject(projectId)
                .map(project -> new ResponseEntity<>(project, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<ProjectDTO>> getByCompany(@PathVariable("companyId") int companyId) {
        return projectDTOService.getByCompanyId(companyId)
                .map(projects -> new ResponseEntity<>(projects, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/param")
    public ResponseEntity<List<ProjectDTO>> getProjectByDescriptionAndCompanyId(
            @RequestParam("description") String description,
            @RequestParam("companyId") long companyId) {
        return projectDTOService.getByDescriptionContainingIgnoreCaseAndCompanyId(description, companyId)
                .map(projects -> new ResponseEntity<>(projects, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @PostMapping("/save")
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO project) {
        return new ResponseEntity<>(projectDTOService.save(project), HttpStatus.CREATED);
    }

    @PutMapping("/save")
    public ResponseEntity<ProjectDTO> update(@RequestBody ProjectDTO project) {
        return new ResponseEntity<>(projectDTOService.update(project), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long projectId) {
        if (projectDTOService.delete(projectId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
