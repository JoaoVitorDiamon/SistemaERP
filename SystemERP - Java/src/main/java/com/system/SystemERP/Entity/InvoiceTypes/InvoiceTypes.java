package com.system.SystemERP.Entity.InvoiceTypes;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
@Data
@Entity
@Table(name = "\"InvoiceTypes\"")
public class InvoiceTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdInvoiceTypes\"")
    private Integer IdInvoiceTypes;

    @Column(name = "\"InvoiceTypes\"")
    private String InvoiceTypes;

    @CreationTimestamp
    @Column(name = "\"DateCreation\"")
    private Instant DateCreation;

    @UpdateTimestamp
    @Column(name = "\"DateUpdate\"")
    private Instant DateUpdate;

    public InvoiceTypes() {
    }

    public InvoiceTypes(Integer idInvoiceTypes, String invoiceTypes, Instant dateCreation, Instant dateUpdate) {
        IdInvoiceTypes = idInvoiceTypes;
        InvoiceTypes = invoiceTypes;
        DateCreation = dateCreation;
        DateUpdate = dateUpdate;
    }
}
