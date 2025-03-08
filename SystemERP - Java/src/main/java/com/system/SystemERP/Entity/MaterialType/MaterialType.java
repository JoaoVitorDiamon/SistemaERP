package com.system.SystemERP.Entity.MaterialType;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"MaterialType\"")
public class MaterialType {

    @Id
    @Column(name = "\"IdMaterialType\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMaterialType;

    @Column(name = "\"MaterialType\"")
    private String MaterialType;

    public MaterialType() {
    }

    public MaterialType(Integer idMaterialType, String materialType) {
        IdMaterialType = idMaterialType;
        MaterialType = materialType;
    }
}
