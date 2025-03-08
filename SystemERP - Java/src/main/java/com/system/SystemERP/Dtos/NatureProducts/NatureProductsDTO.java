package com.system.SystemERP.Dtos.NatureProducts;

import com.system.SystemERP.Entity.NatureProduct.NatureProduct;

public record NatureProductsDTO(
    String Nome
) {
    public NatureProduct toEntity(){
        return new NatureProduct(
            null,
                Nome
        );
    }
}
