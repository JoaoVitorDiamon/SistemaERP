package com.system.SystemERP.Entity.SerialNumberControl;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"SerialNumberControl\"")
public class SerialNumberControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSerialNumberControl")
    private Integer IdSerialNumberControl;
    @Column(name = "Name")
    private String Name;

}
