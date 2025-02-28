package com.system.SystemERP.Entity.Sector;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Setores")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idSetor;
    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Enterprise> empresas;

    public Sector(Integer idSetor, String nome, List<Enterprise> empresas) {
        this.idSetor = idSetor;
        this.nome = nome;
        this.empresas = empresas;
    }
}
