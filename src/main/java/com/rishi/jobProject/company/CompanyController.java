package com.rishi.jobProject.company;

import com.rishi.jobProject.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanySerivce companySerivce;

    public CompanyController(CompanySerivce companySerivce) {
        this.companySerivce = companySerivce;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){

        return new ResponseEntity<>( companySerivce.getAllCompanies(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable long id,@RequestBody Company company){
        companySerivce.updateCompany(company,id);
        return new ResponseEntity<>("Company update succesfully", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companySerivce.createCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComapnybyID(@PathVariable Long id){
        boolean deleted = companySerivce.deleteCompnyById(id);
        if(deleted) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findComapnybyID(@PathVariable Long id){
        Company com = companySerivce.findComapnybyID(id);
        if(com!=null){
            return new ResponseEntity<>(com, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
