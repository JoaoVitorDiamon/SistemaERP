package com.system.SystemERP.Controller.ExpenseReport;


import com.system.SystemERP.Dtos.ExpenseReport.ExpenseReportDTO;
import com.system.SystemERP.Entity.ExpenseReport.ExpenseReport;
import com.system.SystemERP.Services.ExpenseReport.ExpenseReportServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/expenseReport")
public class ExpenseReportController {

    private ExpenseReportServices expenseReportServices;

    public ExpenseReportController(ExpenseReportServices expenseReportServices) {
        this.expenseReportServices = expenseReportServices;
    }

    @PostMapping
    public ResponseEntity<String> createExpenseReport(@RequestBody ExpenseReportDTO expenseReportDTO) {
        var saved = expenseReportServices.createExpenseReport(expenseReportDTO);
        return ResponseEntity.created(URI.create(saved.toString()))
                .build();
    }

    @GetMapping("/{idExpenseReport}")
    public ResponseEntity<ExpenseReport> findById(@PathVariable Integer idExpenseReport){
        var entity = expenseReportServices.findById(idExpenseReport);
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseReport>> findAll(){
        var entity = expenseReportServices.findAll();
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{idExpenseReport}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer idExpenseReport){
        expenseReportServices.deleteById(idExpenseReport);
        return ResponseEntity.noContent()
                .build();
    }

}
