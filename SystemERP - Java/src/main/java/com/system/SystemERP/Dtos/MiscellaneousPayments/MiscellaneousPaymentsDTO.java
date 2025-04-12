package com.system.SystemERP.Dtos.MiscellaneousPayments;

import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.MiscellaneousPayments.MiscellaneousPayments;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;

import java.util.Date;

public record MiscellaneousPaymentsDTO(Date DatePayment, Date DateValue, String Label, String TransferNumber,
                                       String SenderName, String BankCheck, Integer IdPaymentsTypes,
                                       Integer IdAccountBank) {


    public MiscellaneousPayments toEntity(TypesPaymentsServices typesPaymentsServices, AccountBankServices accountBankServices) {
        return new MiscellaneousPayments(
                null,
                DatePayment,
                DateValue,
                Label,
                TransferNumber,
                SenderName,
                BankCheck,
                fetchTypesPaymentsById(IdPaymentsTypes, typesPaymentsServices),
                fetchAccountBankById(IdAccountBank, accountBankServices)
        );

    }

    private AccountBank fetchAccountBankById(Integer accountBankId, AccountBankServices accountBankServices) {
        var accountBank = accountBankServices.findByID(accountBankId);
        return accountBank;
    }

    private TypesPayments fetchTypesPaymentsById(Integer typePaymentID, TypesPaymentsServices typesPaymentsServices) {
        var typesPayments = typesPaymentsServices.findByID(typePaymentID);
        return typesPayments.orElseThrow(() -> new EntityNotFoundException("Tipo de Pagamento nao encontrado"));
    }

}
