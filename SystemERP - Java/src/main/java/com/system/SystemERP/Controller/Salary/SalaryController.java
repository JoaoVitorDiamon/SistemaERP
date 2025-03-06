package com.system.SystemERP.Controller.Salary;

import com.system.SystemERP.Dtos.Salary.SalaryDTO;
import com.system.SystemERP.Entity.Salary.Salary;
import com.system.SystemERP.Services.Salary.SalaryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/salary")
@RestController
public class SalaryController {

    @Autowired
    private SalaryServices salaryServices;


    @PostMapping
    public ResponseEntity<String> creteSalary(@RequestBody SalaryDTO salaryDTO) {
        var salaryID = salaryServices.createSalary(salaryDTO);
        return ResponseEntity.created(URI.create("/salary" + salaryID.toString())).build();
    }

    @GetMapping("/{idSalary}")
    public ResponseEntity<Salary> findByID(@PathVariable Integer idSalary) {
        var salary = salaryServices.findByID(idSalary);

        return salary.isPresent()
                ? ResponseEntity.ok(salary.get())
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/enterprise/{IdEnterprise}")
    public ResponseEntity<List<Salary>> findByIdEnterprise(@PathVariable Integer IdEnterprise) {
        var salary = salaryServices.findByIdEnterprise(IdEnterprise);
        return ResponseEntity.ok(salary);
    }


    @GetMapping
    public ResponseEntity<List<Salary>> findAll() {
        var listSalary = salaryServices.findAll();
        return ResponseEntity.ok(listSalary);
    }

    @DeleteMapping("/{idSalary}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idSalary) {
        salaryServices.DeleteByID(idSalary);
        return ResponseEntity.noContent().build();
    }
}
