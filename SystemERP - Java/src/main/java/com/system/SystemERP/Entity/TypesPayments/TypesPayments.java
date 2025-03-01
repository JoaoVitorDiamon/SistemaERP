package com.system.SystemERP.Entity.TypesPayments;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Data
@Table(name = "\"TypesPayments\"")
public class TypesPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdTypesPayments\"")
    private Integer IdTypesPayments;

    @Column(name = "\"TypePayment\"")
    private String typePayment;

    @CreationTimestamp
    @Column(name = "\"DateCreation\"")
    private Instant DateCreation;

    @UpdateTimestamp
    @Column(name = "\"DateUpdate\"")
    private Instant DateUpdate;


    public TypesPayments() {
    }

    public TypesPayments(Integer id, String typePayment, Instant dateCreation, Instant dateUpdate) {
        this.IdTypesPayments = id;
        this.typePayment = typePayment;
        this.DateCreation = dateCreation;
        this.DateUpdate = dateUpdate;
    }
}
