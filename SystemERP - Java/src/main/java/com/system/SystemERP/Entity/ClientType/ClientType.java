package com.system.SystemERP.Entity.ClientType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "\"ClientType\"")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdClientType\"")
    private Integer IdClientType;

    @Column(name = "\"Name\"")
    private String Name;
}
