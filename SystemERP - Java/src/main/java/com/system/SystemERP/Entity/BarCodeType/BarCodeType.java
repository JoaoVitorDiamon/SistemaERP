package com.system.SystemERP.Entity.BarCodeType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "BarCodeType")
public class BarCodeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBarCodeType;
    private String name;
}
