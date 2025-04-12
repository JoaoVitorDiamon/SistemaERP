package com.system.SystemERP.Controller.SupplierInvoice;


import com.system.SystemERP.Dtos.SupplierInvoice.SupplierInvoiceDTO;
import com.system.SystemERP.Entity.SupplierInvoice.SupplierInvoice;
import com.system.SystemERP.Services.SupplierInvoice.SupplierInvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/supplierInvoice")
public class SupplierInvoiceController {
    private SupplierInvoiceServices supplierInvoiceServices;

    public SupplierInvoiceController(SupplierInvoiceServices supplierInvoiceServices) {
        this.supplierInvoiceServices = supplierInvoiceServices;
    }


    @PostMapping
    public ResponseEntity<String> createSupplierInvoice(@RequestBody SupplierInvoiceDTO supplierInvoiceDTO) {
        var saved = supplierInvoiceServices.createSupplierInvoice(supplierInvoiceDTO);
        return ResponseEntity.created(URI.create("/supplierInvoice" + saved.toString())).build();

    }

    @GetMapping("/{idSupplierInvoice}")
    public ResponseEntity<SupplierInvoice> findByID(@PathVariable Integer idSupplierInvoice) {
        var entityPresent = supplierInvoiceServices.findByID(idSupplierInvoice);
        return ResponseEntity.ok(entityPresent);
    }

    @GetMapping
    public ResponseEntity<List<SupplierInvoice>> getAll() {
        var listSupplier = supplierInvoiceServices.getAll();
        return ResponseEntity.ok(listSupplier);

    }

    @DeleteMapping("/{idSupplierInvoice}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idSupplierInvoice) {
        supplierInvoiceServices.deleteByID(idSupplierInvoice);
        return ResponseEntity.noContent().build();
    }

}
