package com.system.SystemERP.Entity.PaymentTerms;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "\"PaymentTerms\"")
public class PaymentTerms {
    @Id
    @Column(name = "\"IdPaymentTerms\"")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPaymentTerms;

    @Column(name = "\"NamePaymentTerms\"")
    private String namePaymentTerms;

    @CreationTimestamp
    @Column(name = "\"DateCreation\"")
    private Instant dateCreation;

    @UpdateTimestamp
    @Column(name = "\"DateUpdate\"")
    private Instant dateUpdate;

    public PaymentTerms() {
    }

    public PaymentTerms(Integer idPaymentTerms, String namePaymentTerms, Instant dateCreation, Instant dateUpdate) {
        this.idPaymentTerms = idPaymentTerms;
        this.namePaymentTerms = namePaymentTerms;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
    }


}
