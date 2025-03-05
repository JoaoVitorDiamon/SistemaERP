package com.system.SystemERP.Entity.SupplierInvoice;


import com.system.SystemERP.Entity.InvoiceTypes.InvoiceTypes;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "\"SupplierInvoice\"")
public class SupplierInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"SupplierInvoice\"")
    private Integer IdSupplierInvoice;

    @ManyToOne
    @JoinColumn(name = "\"IdSupplier\"", foreignKey = @ForeignKey(name = "\"FK_IdSupplier_SupplierInvoice\""))
    private ThirdParty IdSupplier;

    @ManyToOne
    @JoinColumn(name = "\"IdInvoiceTypes\"", foreignKey = @ForeignKey(name = "\"FK_IdInvoiceTypes_SupplierInvoice\""))
    private InvoiceTypes IdInvoiceTypes;

    @Column(name = "\"InvoiceDate\"")
    private Date InvoiceDate;

    @ManyToOne
    @JoinColumn(name = "\"IdAccountBank\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountBank_SupplierInvoice\""))
    private com.system.SystemERP.Entity.AccountBank.AccountBank AccountBank;

    @ManyToOne
    @JoinColumn(name = "\"IdTypePayments\"", nullable = false, foreignKey = @ForeignKey(name = "\"FK_IdTypePayment_SupplierInvoice\""))
    private TypesPayments TypePayment;


    @Column(name = "\"Value\"")
    private Double Value;

    @Column(name = "\"Note\"")
    private String Note;


    public SupplierInvoice() {
    }

    public SupplierInvoice(Integer idSupplierInvoice, ThirdParty idSupplier, InvoiceTypes idInvoiceTypes, Date invoiceDate, com.system.SystemERP.Entity.AccountBank.AccountBank accountBank, TypesPayments typePayment, Double value, String note) {
        IdSupplierInvoice = idSupplierInvoice;
        IdSupplier = idSupplier;
        IdInvoiceTypes = idInvoiceTypes;
        InvoiceDate = invoiceDate;
        AccountBank = accountBank;
        TypePayment = typePayment;
        Value = value;
        Note = note;
    }
}
