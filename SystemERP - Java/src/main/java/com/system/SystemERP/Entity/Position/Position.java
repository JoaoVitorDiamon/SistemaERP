package com.system.SystemERP.Entity.Position;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "\"Cargos\"")
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idCargo;

    @Column(name = "\"Name\"")
    private String Name;
}
