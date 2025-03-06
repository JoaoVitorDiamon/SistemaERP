package com.system.SystemERP.Repository.SupplierInvoice;

import com.system.SystemERP.Entity.SupplierInvoice.SupplierInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierInvoiceRepository  extends JpaRepository<SupplierInvoice, Integer> {



}
