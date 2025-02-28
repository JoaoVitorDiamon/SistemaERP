package com.system.SystemERP.Entity.Storage;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"armazem\"")
public class Storage {
    public Storage(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_armazem;
    private String nome;
    private String descricao;
    private String telefone;


    public Storage(Integer id_armazem, String nome, String descricao, String telefone) {
        this.id_armazem = id_armazem;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
    }
}