package com.system.SystemERP.Repository.InvoiceTypes;

import com.system.SystemERP.Entity.InvoiceTypes.InvoiceTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceTypesRepository extends JpaRepository<InvoiceTypes, Integer> {
}
