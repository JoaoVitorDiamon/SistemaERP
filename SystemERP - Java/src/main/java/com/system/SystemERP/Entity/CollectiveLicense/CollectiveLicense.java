package com.system.SystemERP.Entity.CollectiveLicense;


import com.system.SystemERP.Entity.LicenseType.LicenseType;
import com.system.SystemERP.Entity.Members.Members;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "\"CollectiveLicense\"")
public class CollectiveLicense {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "\"IdCollectiveLicense\"")
        private Integer idCollectiveLicense;

        @ManyToOne
        @JoinColumn(name = "\"IdLicenseType\"", foreignKey = @ForeignKey(name = "\"FK_IDLicenseType_CollectiveLicense\""))
        private LicenseType licenseType;

        @Column(name = "\"InicialDate\"")
        private Date inicialDate;

        @Column(name = "\"EndDate\"")
        private Date endDate;

        @ManyToOne
        @JoinColumn(name = "\"IdManager\"", foreignKey = @ForeignKey(name = "FK_IdMembres_CollectiveLicense"))
        private Members idManager;

        @Column(name = "\"Description\"")
        private String description;


        @ManyToMany
        @JoinTable(
                name = "\"CollectiveLicense_Members\"",
                joinColumns = @JoinColumn(name = "\"IdCollectiveLicense\""),
                inverseJoinColumns = @JoinColumn(name = "\"IdMembers\"")
        )
        private List<Members> members;

        public CollectiveLicense() {
        }

        public CollectiveLicense(Integer idCollectiveLicense, LicenseType licenseType, Date inicialDate, Date endDate, Members idManager, String description,List<Members> members) {
                this.idCollectiveLicense = idCollectiveLicense;
                this.licenseType = licenseType;
                this.inicialDate = inicialDate;
                this.endDate = endDate;
                this.idManager = idManager;
                this.description = description;
                this.members = members;
        }


}
