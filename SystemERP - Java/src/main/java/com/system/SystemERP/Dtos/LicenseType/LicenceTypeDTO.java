package com.system.SystemERP.Dtos.LicenseType;

import com.system.SystemERP.Entity.LicenseType.LicenseType;
import com.system.SystemERP.Enum.LicenseType.LicenseTypeEnum;

public record LicenceTypeDTO(LicenseTypeEnum licenseTypeEnum) {

    public LicenseType toEntity() {
        return new LicenseType(
                null,
                licenseTypeEnum.name()
        );
    }
}
