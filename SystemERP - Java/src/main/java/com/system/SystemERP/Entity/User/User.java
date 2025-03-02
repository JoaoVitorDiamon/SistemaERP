package com.system.SystemERP.Entity.User;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"Users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdUser\"")
    private int IDUser;

    @Column(name = "\"Name\"", length = 255)
    private String Name;

    @Column(name = "\"Email\"", length = 255)
    private String Email;

    @CreationTimestamp
    @Column(name = "\"CreationDate\"", length = 255)
    private Instant CreationDate;

    @Column(name = "\"Password\"")
    private String Password;

    @Column(name = "\"CPF\"")
    private String CPF;

}