package com.system.SystemERP.Entity.Coin;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "\"moeda\"")
@Entity
@Data
public class Coin {

    @Id
    private Integer id;

    private String nome;
}
