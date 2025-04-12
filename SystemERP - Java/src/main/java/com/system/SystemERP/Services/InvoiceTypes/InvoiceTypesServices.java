package com.system.SystemERP.Services.InvoiceTypes;


import com.system.SystemERP.Dtos.InvoiceTypes.InvoiceTypesDTO;
import com.system.SystemERP.Entity.InvoiceTypes.InvoiceTypes;
import com.system.SystemERP.Repository.InvoiceTypes.InvoiceTypesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

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

    public InvoiceTypes getByID(Integer id) {return invoiceTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fatura nao encontrada!"));}

    public List<InvoiceTypes> getAll() {
        return invoiceTypeRepository.findAll();
    }

    public void deleteByID(Integer Id) {
        var typesExists = invoiceTypeRepository.existsById(Id);

        if (!typesExists) {
            throw new EntityNotFoundException("Fatura nao encontrada!");
        }

        invoiceTypeRepository.deleteById(Id);
    }
}
