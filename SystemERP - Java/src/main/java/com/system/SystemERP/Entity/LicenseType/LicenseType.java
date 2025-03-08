package com.system.SystemERP.Entity.LicenseType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"LicenseType\"")
public class LicenseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdLicenseType\"")
    private Integer IdLicenseType;

    @Column(name = "\"LicenseType\"")
    private String LicenseType;

    public LicenseType() {
    }

    public LicenseType(Integer idLicenseType, String licenseType) {
        IdLicenseType = idLicenseType;
        LicenseType = licenseType;
    }
}
