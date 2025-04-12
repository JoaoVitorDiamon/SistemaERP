package com.system.SystemERP.Services.SupplierInvoice;


import com.system.SystemERP.Dtos.SupplierInvoice.SupplierInvoiceDTO;
import com.system.SystemERP.Entity.SupplierInvoice.SupplierInvoice;
import com.system.SystemERP.Repository.SupplierInvoice.SupplierInvoiceRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.InvoiceTypes.InvoiceTypesServices;
import com.system.SystemERP.Services.ThirdParties.ThirdPartiesServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierInvoiceServices {

    private SupplierInvoiceRepository supplierInvoiceRepository;
    private AccountBankServices accountBankServices;
    private InvoiceTypesServices invoiceTypesServices;
    private TypesPaymentsServices typesPaymentsServices;
    private ThirdPartiesServices thirdPartiesServices;

    public SupplierInvoiceServices(SupplierInvoiceRepository supplierInvoiceRepository, AccountBankServices accountBankServices, InvoiceTypesServices invoiceTypesServices, TypesPaymentsServices typesPaymentsServices, ThirdPartiesServices thirdPartiesServices) {
        this.supplierInvoiceRepository = supplierInvoiceRepository;
        this.accountBankServices = accountBankServices;
        this.invoiceTypesServices = invoiceTypesServices;
        this.typesPaymentsServices = typesPaymentsServices;
        this.thirdPartiesServices = thirdPartiesServices;
    }



    public Integer createSupplierInvoice(SupplierInvoiceDTO supplierInvoiceDTO) {
        var supplier = supplierInvoiceDTO.toEntity(accountBankServices, typesPaymentsServices, invoiceTypesServices, thirdPartiesServices);
        supplier = supplierInvoiceRepository.save(supplier);
        return supplier.getIdSupplierInvoice();
    }

    public SupplierInvoice findByID(Integer ID) {
        return supplierInvoiceRepository.findById(ID).orElseThrow(() -> new EntityNotFoundException("Fatura nao encontrada"));
    }

    public List<SupplierInvoice> getAll() {
        return supplierInvoiceRepository.findAll();
    }

    public void deleteByID(Integer ID) {
        var exists = supplierInvoiceRepository.existsById(ID);
        if (!exists) throw new EntityNotFoundException("Fatura nao encontrada");
        supplierInvoiceRepository.deleteById(ID);
    }

}
