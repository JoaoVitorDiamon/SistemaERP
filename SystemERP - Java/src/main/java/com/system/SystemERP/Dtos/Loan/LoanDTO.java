package com.system.SystemERP.Dtos.Loan;

import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Loan.Loan;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;

import java.util.Date;

public record LoanDTO(Double capital, Date inicialDate, Date endDate, Integer numberTerms,
                      Double type, Double insurance, String notice, Integer idAccountingCode,
                      Integer idAccountBank, Double valuePaid, Double remainingValue) {


    public Loan toEntity(AccountBankServices accountBankServices, AccountingCodeServices accountingCodeServices) {
        return new Loan(
                null,
                capital,
                inicialDate,
                endDate,
                numberTerms,
                type,
                insurance,
                notice,
                fetchAccountingCodeByID(idAccountingCode, accountingCodeServices),
                fetchAccountBankById(idAccountBank, accountBankServices),
                valuePaid,
                remainingValue
        );
    }


    private AccountBank fetchAccountBankById(Integer accountBankId, AccountBankServices accountBankServices) {
        var accountBank = accountBankServices.findByID(accountBankId);
        return accountBank;
    }

    private AccountingCode fetchAccountingCodeByID(Integer Id, AccountingCodeServices accountingCodeServices) {
        var accountingCode = accountingCodeServices.findByID(Id);
        return accountingCode;
    }

}
