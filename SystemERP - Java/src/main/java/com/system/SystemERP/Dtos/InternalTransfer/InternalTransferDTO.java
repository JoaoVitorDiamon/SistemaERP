package com.system.SystemERP.Dtos.InternalTransfer;

import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.InternalTransfer.InternalTransfer;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;

import java.util.Date;

public record InternalTransferDTO(Integer IdAccountPayment, Integer IdAccountReceiver, Integer IdPaymentType, Date DatePayment,String Description, Double Value) {


    public InternalTransfer toEntity(AccountBankServices accountBankServices, TypesPaymentsServices typesPaymentsServices) {
        return new InternalTransfer(
                null,
                fetchAccountBankByID(IdAccountPayment, accountBankServices),
                fetchAccountBankByID(IdAccountReceiver, accountBankServices),
                fetchTypesPaymentsByID(IdPaymentType,typesPaymentsServices),
                DatePayment,
                Description,
                Value
                );
    }

    private AccountBank fetchAccountBankByID(Integer Id, AccountBankServices accountBankServices){
        var accountBank = accountBankServices.findByID(Id);
        return accountBank.get();
    }

    private TypesPayments fetchTypesPaymentsByID(Integer Id, TypesPaymentsServices typesPaymentsServices){
        var typesPayments = typesPaymentsServices.findByID(Id);
        return typesPayments.get();
    }
}