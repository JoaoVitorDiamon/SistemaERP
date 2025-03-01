package com.system.SystemERP.Entity.Sector;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"Sector\"")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdSector\"")
    private Integer IdSector;
    @Column(name = "\"Name\"")
    private String Name;
}
