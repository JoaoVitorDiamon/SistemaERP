package com.system.SystemERP.Entity.Sector;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"Setores\"")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idSetor;
    @Column(name = "\"Nome\"")
    private String Nome;
}
