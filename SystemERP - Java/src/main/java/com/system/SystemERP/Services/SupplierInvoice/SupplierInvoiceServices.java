package com.system.SystemERP.Services.SupplierInvoice;


import com.system.SystemERP.Dtos.SupplierInvoice.SupplierInvoiceDTO;
import com.system.SystemERP.Entity.SupplierInvoice.SupplierInvoice;
import com.system.SystemERP.Repository.SupplierInvoice.SupplierInvoiceRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.InvoiceTypes.InvoiceTypesServices;
import com.system.SystemERP.Services.ThirdParties.ThirdPartiesServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierInvoiceServices {

    @Autowired
    private SupplierInvoiceRepository supplierInvoiceRepository;
    @Autowired
    private AccountBankServices accountBankServices;
    @Autowired
    private InvoiceTypesServices invoiceTypesServices;
    @Autowired
    private TypesPaymentsServices typesPaymentsServices;
    @Autowired
    private ThirdPartiesServices thirdPartiesServices;


    public Integer createSupplierInvoice(SupplierInvoiceDTO supplierInvoiceDTO) {
        var supplier = supplierInvoiceDTO.toEntity(accountBankServices, typesPaymentsServices, invoiceTypesServices, thirdPartiesServices);
        supplier = supplierInvoiceRepository.save(supplier);
        return supplier.getIdSupplierInvoice();
    }

    public Optional<SupplierInvoice> findByID(Integer ID) {
        return supplierInvoiceRepository.findById(ID);
    }

    public List<SupplierInvoice> getAll() {
        return supplierInvoiceRepository.findAll();
    }

    public void deleteByID(Integer ID) {
        var exists = supplierInvoiceRepository.existsById(ID);
        if (exists) {
            supplierInvoiceRepository.deleteById(ID);
        }
    }

}
