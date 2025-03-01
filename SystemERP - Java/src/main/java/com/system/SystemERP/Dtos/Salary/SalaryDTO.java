package com.system.SystemERP.Dtos.Salary;

import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Entity.Salary.Salary;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.Members.MembersServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;

import java.time.Instant;
import java.util.Date;

public record SalaryDTO(String label, Date dateStart, Date endDate, Double value, Integer accountBankID, Integer memberID, Integer typePaymentID,String transferNumber) {


    public Salary toEntity(AccountBankServices accountBankServices, TypesPaymentsServices typesPaymentsServices, MembersServices membersServices){
        return new Salary(
                null,
                fetchMemberById(memberID, membersServices),
                label,
                dateStart,
                endDate,
                value,
                fetchAccountBankById(accountBankID, accountBankServices),
                fetchTypesPaymentsById(typePaymentID, typesPaymentsServices),
                Instant.now(),
                transferNumber
        );
    }

    private AccountBank fetchAccountBankById(Integer accountBankId, AccountBankServices accountBankServices) {
        var accountBank = accountBankServices.findByID(accountBankId);
        return accountBank.orElseThrow(() -> new EntityNotFoundException("Conta Bancaria não encontrada"));
    }

    private TypesPayments fetchTypesPaymentsById(Integer typePaymentID, TypesPaymentsServices typesPaymentsServices){
        var typesPayments = typesPaymentsServices.findByID(typePaymentID);
        return typesPayments.orElseThrow(() -> new EntityNotFoundException("Tipo de Pagamento nao encontrado"));
    }

    private Members fetchMemberById(Integer memberID, MembersServices membersServices){
        var members = membersServices.findById(memberID);
        return members.orElseThrow(() -> new EntityNotFoundException("Membro nao Encontrado"));

    }


}
