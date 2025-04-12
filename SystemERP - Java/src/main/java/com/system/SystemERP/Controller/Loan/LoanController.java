package com.system.SystemERP.Controller.Loan;


import com.system.SystemERP.Dtos.Loan.LoanDTO;
import com.system.SystemERP.Entity.Loan.Loan;
import com.system.SystemERP.Services.Loan.LoanServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {


    private LoanServices loanServices;

    public LoanController(LoanServices loanServices) {
        this.loanServices = loanServices;
    }

    @PostMapping
    public ResponseEntity<String> createLoan(@RequestBody LoanDTO loanDTO) {
        var saved = loanServices.createLoan(loanDTO);
        return ResponseEntity.created(URI.create("/loan" + saved.toString())).build();
    }

    @GetMapping("/{idLoan}")
    public ResponseEntity<Loan> findById(@PathVariable Integer idLoan) {
        var loan = loanServices.findByID(idLoan);
        return ResponseEntity.ok(loan);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAll() {
        var listLoan = loanServices.getAll();
        return ResponseEntity.ok(listLoan);
    }

    @DeleteMapping("/{idLoan}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idLoan) {
        loanServices.deleteById(idLoan);
        return ResponseEntity
                .noContent()
                .build();

    }


}
