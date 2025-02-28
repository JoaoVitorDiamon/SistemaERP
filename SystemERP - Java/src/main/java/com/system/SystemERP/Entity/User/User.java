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
@Table(name = "\"Usuarios\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    @Column(name = "\"Nome\"", length = 255)
    private String Nome;
    @Column(name = "\"CPF\"", length = 255)
    private String CPF;
    @Column(name = "\"Email\"", length = 255)
    private String Email;
    @Column(name = "\"DataCriacao\"", length = 255)
    private Date DataCriacao;
    @Column(name = "\"Senha\"")
    private String Senha;

}