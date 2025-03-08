package com.system.SystemERP.Dtos.MaterialType;

import com.system.SystemERP.Entity.MaterialType.MaterialType;

public record MaterialTypeDTO(String materialType) {


    public MaterialType toEntity() {
        return new MaterialType(
                null,
                materialType
        );
    }
}
