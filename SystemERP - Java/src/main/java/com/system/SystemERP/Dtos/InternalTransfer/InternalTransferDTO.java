package com.system.SystemERP.Dtos.InternalTransfer;

import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.InternalTransfer.InternalTransfer;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;

import java.util.Date;

public record InternalTransferDTO(
        Integer IdAccountPayment,
        Integer IdAccountReceiver,
        Integer IdPaymentType,
        Date DatePayment,
        String Description,
        Double Value) {


    public InternalTransfer toEntity(AccountBankServices accountBankServices, TypesPaymentsServices typesPaymentsServices) {

        return new InternalTransfer(
                null,
                fetchAccountBankById(IdAccountPayment, accountBankServices),
                fetchAccountBankById(IdAccountReceiver, accountBankServices),
                fetchTypesPaymentsByID(IdPaymentType,typesPaymentsServices),
                DatePayment,
                Description,
                Value
                );
    }

    private AccountBank fetchAccountBankById(Integer accountBankId, AccountBankServices accountBankServices) {
        var accountBank = accountBankServices.findByID(accountBankId);
        return accountBank.orElseThrow(() -> new EntityNotFoundException("Conta Bancaria não encontrada"));
    }

    private TypesPayments fetchTypesPaymentsByID(Integer Id, TypesPaymentsServices typesPaymentsServices){
        var typesPayments = typesPaymentsServices.findByID(Id);
        return typesPayments.orElseThrow(() -> new EntityNotFoundException("Tipo nao encontrado"));
    }
}