package com.system.SystemERP.Services.Loan;


import com.system.SystemERP.Dtos.Loan.LoanDTO;
import com.system.SystemERP.Entity.Loan.Loan;
import com.system.SystemERP.Repository.Loan.LoanRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServices {


    private LoanRepository loanRepository;
    private AccountingCodeServices accountingCodeServices;
    private AccountBankServices accountBankServices;

    public LoanServices(LoanRepository loanRepository, AccountingCodeServices accountingCodeServices, AccountBankServices accountBankServices) {
        this.loanRepository = loanRepository;
        this.accountingCodeServices = accountingCodeServices;
        this.accountBankServices = accountBankServices;
    }

    public Integer createLoan(LoanDTO loanDTO) {
        var loan = loanDTO.toEntity(accountBankServices, accountingCodeServices);
        loan = loanRepository.save(loan);
        return loan.getIdLoan();
    }

    public Loan findByID(Integer Id) {
        return loanRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Emprestimo nao encontrado!"));
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    public void deleteById(Integer Id) {
        var exists = loanRepository.existsById(Id);
        if (!exists) throw new EntityNotFoundException("Emprestimo nao encontrado!");

        loanRepository.deleteById(Id);
    }

}
