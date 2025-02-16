package com.system.SystemERP.Entity.PaymentTerms;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "termos_de_pagamento")
public class PaymentTerms {
    @Id
    @Column(name = "idTermosDePagamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPaymentTerms;

    @Column(name = "nomeTermosDePagamentos")
    private String namePaymentTerms;

    @CreationTimestamp
    @Column(name = "dataCriacao")
    private Instant dateCreation;

    @UpdateTimestamp
    @Column(name = "dataAtualizacao")
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
