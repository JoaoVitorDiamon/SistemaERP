package com.system.SystemERP.Entity.Position;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "\"Position\"")
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdPosition\"")
    private Integer IdPosition;

    @Column(name = "\"Name\"")
    private String Name;
}
