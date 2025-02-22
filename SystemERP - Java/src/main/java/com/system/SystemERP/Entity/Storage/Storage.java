package com.system.SystemERP.Entity.Storage;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "armazem")
public class Storage {
    public Storage(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idArmazem;
    private String nome;
    private String descricao;
    //private Integer endereco_idEndereco;(fk)
    private String telefone;
    //private Integer empresa_idEmpresA;(FK)


    public Storage(Integer idArmazem, String nome, String descricao, String telefone) {
        this.idArmazem = idArmazem;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
    }
}
