package com.system.SystemERP.Services.Loan;


import com.system.SystemERP.Dtos.Loan.LoanDTO;
import com.system.SystemERP.Entity.Loan.Loan;
import com.system.SystemERP.Repository.Loan.LoanRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServices {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AccountingCodeServices accountingCodeServices;

    @Autowired
    private AccountBankServices accountBankServices;


    public Integer createLoan(LoanDTO loanDTO) {
        var loan = loanDTO.toEntity(accountBankServices, accountingCodeServices);
        loan = loanRepository.save(loan);
        return loan.getIdLoan();
    }
    public Optional<Loan> findByID(Integer Id){
    return loanRepository.findById(Id);
    }

    public List<Loan> getAll(){
        return loanRepository.findAll();
    }

    public void deleteById(Integer Id){
         var exists = loanRepository.existsById(Id);
         if(exists){
             loanRepository.deleteById(Id);
         }
    }

}
