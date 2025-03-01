package com.system.SystemERP.Entity.Enterprise;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.EnterpriseType.EnterpriseType;
import com.system.SystemERP.Entity.Sector.Sector;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"Enterprise\"")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdEnterprise\"")
    private Integer IdEnterprise;
    @Column(name = "\"Name\"")
    private String Name;
    @Column(name = "\"NameFantasy\"")
    private String NameFantasy;
    @Column(name = "\"OwnerId\"")
    private Integer OwnerId;
    @Column(name = "\"CNPJ\"")
    private String CNPJ;
    @Column(name = "\"Email\"")
    private String Email;
    @Column(name = "\"Telephone\"")
    private String Telephone;

    @ManyToOne
    @JoinColumn(name = "IdAddress")
    private Adress Address;


    @ManyToOne
    @JoinColumn(name = "\"IdSector\"")
    private Sector Sector;

    @ManyToOne
    @JoinColumn(name = "\"IdCompanyType\"")
    private EnterpriseType CompanyType;

    @CreationTimestamp
    @Column(name = "\"CreationDate\"")
    private Instant CreationDate;


}