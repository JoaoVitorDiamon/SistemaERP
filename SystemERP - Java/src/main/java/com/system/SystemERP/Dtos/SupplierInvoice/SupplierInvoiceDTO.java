package com.system.SystemERP.Dtos.SupplierInvoice;

import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.InvoiceTypes.InvoiceTypes;
import com.system.SystemERP.Entity.SupplierInvoice.SupplierInvoice;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.InvoiceTypes.InvoiceTypesServices;
import com.system.SystemERP.Services.ThirdParties.ThirdPartiesServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;

import java.util.Date;

public record SupplierInvoiceDTO(Integer IdThirdParty, Integer IdInvoiceTypes, Date InvoiceDate, Integer IdPaymentTerms,
                                 Integer IdAccountBank, Double Value, String Note
) {

    public SupplierInvoice toEntity(AccountBankServices accountBankServices, TypesPaymentsServices typesPaymentsServices,
                                    InvoiceTypesServices invoiceTypesServices, ThirdPartiesServices thirdPartiesServices) {
        return new SupplierInvoice(
                null,
                fetchThirdPartyById(IdThirdParty, thirdPartiesServices),
                fetchInvoiceTypesById(IdInvoiceTypes, invoiceTypesServices),
                InvoiceDate,
                fetchAccountBankById(IdAccountBank, accountBankServices),
                fetchTypesPaymentsById(IdPaymentTerms, typesPaymentsServices),
                Value,
                Note
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

    private InvoiceTypes fetchInvoiceTypesById(Integer invoiceTypesID, InvoiceTypesServices invoiceTypesServices) {
        var invoiceTypes = invoiceTypesServices.getByID(invoiceTypesID);
        return invoiceTypes;

    }

    private ThirdParty fetchThirdPartyById(Integer idThirdParty, ThirdPartiesServices thirdPartiesServices) {
        var thirdParty = thirdPartiesServices.getById(idThirdParty);
        return thirdParty.orElseThrow(() -> new EntityNotFoundException("Fornecedor nao encontrado"));
    }
}
