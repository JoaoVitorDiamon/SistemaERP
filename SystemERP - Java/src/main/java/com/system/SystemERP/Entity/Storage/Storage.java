package com.system.SystemERP.Entity.Storage;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"armazem\"")
public class Storage {
    public Storage(Integer idArmazem, String nome, String descricao, String telefone, Adress endereco, Enterprise empresa){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_armazem;
    private String nome;
    private String descricao;
    private String telefone;


    @ManyToOne
    @JoinColumn(name = "\"idEndereco\"")
    private Adress endereco;

    @ManyToOne
    @JoinColumn(name = "\"idEmpresa\"")
    private Enterprise empresa;

    public Storage(Integer id_armazem, String nome, String descricao, String telefone, Adress endereco) {
        this.id_armazem = id_armazem;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}