package com.system.SystemERP.Entity.TypesPayments;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Data
@Table(name = "tipo_pagamentos")
public class TypesPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "tipo_de_pagamento")
    private String typePayment;

    @CreationTimestamp
    private Instant dateCreation;

    @UpdateTimestamp
    private Instant dateUpdate;

    public TypesPayments() {
    }

    public TypesPayments(Integer id, String typePayment, Instant dateCreation, Instant dateUpdate) {
        this.id = id;
        this.typePayment = typePayment;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
    }
}
