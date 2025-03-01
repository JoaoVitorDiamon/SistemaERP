package com.system.SystemERP.Entity.Coin;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "\"Coin\"")
@Entity
@Data
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdCoin\"")
    private Integer IdCoin;

    @Column(name = "\"Name\"")
    private String Name;
}
