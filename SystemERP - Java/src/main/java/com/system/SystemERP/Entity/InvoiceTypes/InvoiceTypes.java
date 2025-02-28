package com.system.SystemERP.Entity.InvoiceTypes;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
@Data
@Entity
@Table(name = "\"tipos_de_faturas\"")
public class InvoiceTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idInvoiceTypes;

    private String invoiceTypes;

    @CreationTimestamp
    private Instant dateCreation;

    @UpdateTimestamp
    private Instant dateUpdate;

    public InvoiceTypes() {
    }

    public InvoiceTypes(Integer idInvoiceTypes, String invoiceTypes, Instant dateCreation, Instant dateUpdate) {
        this.idInvoiceTypes = idInvoiceTypes;
        this.invoiceTypes = invoiceTypes;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
    }
}
