package com.system.SystemERP.Entity.Enterprise;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.EnterpriseType.EnterpriseType;
import com.system.SystemERP.Entity.Sector.Sector;
import com.system.SystemERP.Entity.User.User;
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
    private Integer idEnterprise;
    @Column(name = "\"Name\"")
    private String Name;
    @Column(name = "\"NameFantasy\"")
    private String NameFantasy;

    @ManyToOne
    @JoinColumn(name = "\"OwnerId\"", foreignKey = @ForeignKey(name = "\"FK_OwnerId_Enterprise\""))
    private User OwnerId;


    @Column(name = "\"CNPJ\"")
    private String CNPJ;
    @Column(name = "\"Email\"")
    private String Email;
    @Column(name = "\"Telephone\"")
    private String Telephone;

    @ManyToOne
    @JoinColumn(name = "IdAddress", foreignKey = @ForeignKey(name = "\"FK_IdAddress_Enterprise\""))
    private Adress Address;


    @ManyToOne
    @JoinColumn(name = "\"IdSector\"", foreignKey = @ForeignKey(name = "\"FK_IdSector_Enterprise\""))
    private Sector Sector;

    @ManyToOne
    @JoinColumn(name = "\"IdCompanyType\"", foreignKey = @ForeignKey(name = "\"FK_IdCompanyType__Enterprise\""))
    private EnterpriseType CompanyType;

    public Enterprise(Integer idEnterprise, String name, String nameFantasy, User ownerId, String CNPJ, String email, String telephone, Adress address, com.system.SystemERP.Entity.Sector.Sector sector, EnterpriseType companyType, Instant creationDate) {
        this.idEnterprise = idEnterprise;
        Name = name;
        NameFantasy = nameFantasy;
        OwnerId = ownerId;
        this.CNPJ = CNPJ;
        Email = email;
        Telephone = telephone;
        Address = address;
        Sector = sector;
        CompanyType = companyType;
        CreationDate = creationDate;
    }

    @CreationTimestamp
    @Column(name = "\"CreationDate\"")
    private Instant CreationDate;


}