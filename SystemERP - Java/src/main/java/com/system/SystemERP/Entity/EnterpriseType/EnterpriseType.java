package com.system.SystemERP.Entity.EnterpriseType;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tipo_de_empresa")
public class EnterpriseType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idTipoDeEmpresa;
    private String name;

    @OneToMany(mappedBy = "tipoDeEmpresa")
    private List<Enterprise> empresas;


    public EnterpriseType(Integer idTipoDeEmpresa, String name, List<Enterprise> empresas) {
        this.idTipoDeEmpresa = idTipoDeEmpresa;
        this.name = name;
        this.empresas = empresas;
    }
}

