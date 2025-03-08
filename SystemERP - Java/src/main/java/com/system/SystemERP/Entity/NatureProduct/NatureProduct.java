package com.system.SystemERP.Entity.NatureProduct;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"NatureProduct\"")
public class NatureProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdNatureProduct\"")
    private Integer IdNatureProduct;
    @Column(name = "\"Name\"")
    private String Name;

    public NatureProduct(Integer idNaturePrduct, String name) {
        IdNatureProduct = idNaturePrduct;
        Name = name;
    }
}
