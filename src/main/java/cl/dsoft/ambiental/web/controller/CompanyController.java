package cl.dsoft.ambiental.web.controller;

import cl.dsoft.ambiental.domain.dto.CompanyDTO;
import cl.dsoft.ambiental.domain.service.CompanyDTOService;
import cl.dsoft.ambiental.persistance.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyDTOService companyDTOService;

    @GetMapping("/all")
    //@ApiOperation("Get all supermarket products")
    //@ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<CompanyDTO>> getAll() {
        return new ResponseEntity<List<CompanyDTO>>(companyDTOService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    //@ApiOperation("Search a product with an ID")
    //@ApiResponses({
    //@ApiResponse(code = 200, message = "OK"),
    //@ApiResponse(code = 404, message = "Product not found"),     })
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable("id") long companyId) {
        return companyDTOService.getCompany(companyId)
                .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /*
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CompanyDTO>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return companyDTOService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    */
    /*
    /companies/param?name={name}
     */
    @GetMapping("/param")
    public ResponseEntity<List<CompanyDTO>> getCompanyByName(
            @RequestParam("name") String name) {
        return companyDTOService.getByNameContaining(name)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @PostMapping("/save")
    public ResponseEntity<CompanyDTO> save(@RequestBody CompanyDTO company) {
        return new ResponseEntity<>(companyDTOService.save(company), HttpStatus.CREATED);
    }

    @PutMapping("/save")
    public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO company) {
        return new ResponseEntity<>(companyDTOService.update(company), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long companyId) {
        if (companyDTOService.delete(companyId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
