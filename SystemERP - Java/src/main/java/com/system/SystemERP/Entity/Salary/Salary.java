package com.system.SystemERP.Entity.Salary;


import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "\"salario\"")
@Entity
@Data
@NoArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salary_id;

    @ManyToOne
    @JoinColumn(name = "Membros_idMembro")
    private Members members;


    private String etiqueta;
    private Date dataInicio;
    private Date dataFinal;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "tipo_pagamento_id", nullable = false)
    private TypesPayments typePayment;



}
