package cl.dsoft.ambiental.web.controller;

import cl.dsoft.ambiental.domain.dto.FindingDTO;
import cl.dsoft.ambiental.domain.service.FindingDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/findings")
public class FindingController {

    @Autowired
    private FindingDTOService findingDTOService;

    @GetMapping("/all")
    //@ApiOperation("Get all supermarket products")
    //@ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<FindingDTO>> getAll() {
        return new ResponseEntity<List<FindingDTO>>(findingDTOService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    //@ApiOperation("Search a product with an ID")
    //@ApiResponses({
    //@ApiResponse(code = 200, message = "OK"),
    //@ApiResponse(code = 404, message = "Product not found"),     })
    public ResponseEntity<FindingDTO> getFinding(@PathVariable("id") long findingId) {
        return findingDTOService.getFinding(findingId)
                .map(finding -> new ResponseEntity<>(finding, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<FindingDTO>> getByProject(@PathVariable("projectId") int projectId) {
        return findingDTOService.getByProjectId(projectId)
                .map(findings -> new ResponseEntity<>(findings, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/param")
    public ResponseEntity<List<FindingDTO>> getFindingByDescriptionAndProjectId(
            @RequestParam("identifier") String identifier,
            @RequestParam("projectId") long projectId) {
        return findingDTOService.getByIdentifierAndProjectId(identifier, projectId)
                .map(findings -> new ResponseEntity<>(findings, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/special")
    public ResponseEntity<List<FindingDTO>> getFindingByDescriptionContainingIgnoreCaseAndProjectId(
            @RequestParam("description") String description,
            @RequestParam("projectId") long projectId) {
        return findingDTOService.getByDescriptionContainingIgnoreCaseAndProjectId(description, projectId)
                .map(findings -> new ResponseEntity<>(findings, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @PostMapping("/save")
    public ResponseEntity<FindingDTO> save(@RequestBody FindingDTO finding) {
        return new ResponseEntity<>(findingDTOService.save(finding), HttpStatus.CREATED);
    }

    @PutMapping("/save")
    public ResponseEntity<FindingDTO> update(@RequestBody FindingDTO finding) {
        return new ResponseEntity<>(findingDTOService.update(finding), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long findingId) {
        if (findingDTOService.delete(findingId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
