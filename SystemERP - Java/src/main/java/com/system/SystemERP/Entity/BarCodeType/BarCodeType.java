package com.system.SystemERP.Entity.BarCodeType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"BarCodeType\"")
public class BarCodeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdBarCodeType\"")
    private Integer IdBarCodeType;

    @Column(name = "\"Name\"")
    private String Name;

    public BarCodeType(Integer idBarCodeType, String name) {
        IdBarCodeType = idBarCodeType;
        Name = name;
    }
}
