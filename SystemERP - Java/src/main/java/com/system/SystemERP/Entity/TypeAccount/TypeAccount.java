package com.system.SystemERP.Entity.TypeAccount;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"tipo_conta\"")
public class TypeAccount {

    @Id
    private Integer id;

    private String nome;

}
