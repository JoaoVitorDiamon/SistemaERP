package com.system.SystemERP.Entity.EnterpriseType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tipo_de_empresa")
public class EnterpriseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoDeEmpresa;
    private String name;

}

