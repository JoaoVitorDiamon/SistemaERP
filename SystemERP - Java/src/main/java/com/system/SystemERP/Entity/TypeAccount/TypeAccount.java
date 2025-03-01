package com.system.SystemERP.Entity.TypeAccount;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"TypeAccount\"")
public class TypeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTypeAccount")
    private Integer IdTypeAccount;

    @Column(name = "Name")
    private String nome;

}
