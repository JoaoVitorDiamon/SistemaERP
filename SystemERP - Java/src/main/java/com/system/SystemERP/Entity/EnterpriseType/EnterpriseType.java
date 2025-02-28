package com.system.SystemERP.Entity.EnterpriseType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"TipoDeEmpresa\"")
public class EnterpriseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idTipoDeEmpresa\"")
    private Integer idTipoDeEmpresa;

    @Column(name = "\"Name\"", length = 255)
    private String Name;

}