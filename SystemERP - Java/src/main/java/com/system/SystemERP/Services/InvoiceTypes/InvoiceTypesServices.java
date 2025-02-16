package com.system.SystemERP.Services.InvoiceTypes;


import com.system.SystemERP.Dtos.InvoiceTypes.InvoiceTypesDTO;
import com.system.SystemERP.Entity.InvoiceTypes.InvoiceTypes;
import com.system.SystemERP.Repository.InvoiceTypes.InvoiceTypesRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceTypesServices {

    private final InvoiceTypesRepository invoiceTypeRepository;

    public InvoiceTypesServices(InvoiceTypesRepository invoiceTypeRepository) {
        this.invoiceTypeRepository = invoiceTypeRepository;
    }

    public Integer createInvoice(InvoiceTypesDTO invoiceTypesDTO) {
        var invoice = new InvoiceTypes(
                null,
                invoiceTypesDTO.nome().name(),
                Instant.now(),
                null
        );
        var saved = invoiceTypeRepository.save(invoice);
        return saved.getIdInvoiceTypes();

    }

    public Optional<InvoiceTypes> getByID(Integer id) {
        return invoiceTypeRepository.findById(id);
    }

    public List<InvoiceTypes> getAll() {
        return invoiceTypeRepository.findAll();
    }

    public void deleteByID(Integer Id) {
        var typesExists = invoiceTypeRepository.existsById(Id);

        if (typesExists) {
            invoiceTypeRepository.deleteById(Id);
        }
    }
}
