package com.system.SystemERP.Entity.User;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Empresas")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String genero;
    private Date dataCriacao;
    private String senha;
    private String CEP;

}
