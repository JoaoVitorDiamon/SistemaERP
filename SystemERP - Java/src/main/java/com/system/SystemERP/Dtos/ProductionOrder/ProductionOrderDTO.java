package com.system.SystemERP.Dtos.ProductionOrder;

import com.system.SystemERP.Entity.MaterialType.MaterialType;
import com.system.SystemERP.Entity.ProductionOrder.ProductionOrder;
import com.system.SystemERP.Entity.Products.Product;
import com.system.SystemERP.Entity.Storage.Storage;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import com.system.SystemERP.Services.MaterialType.MaterialTypeServices;
import com.system.SystemERP.Services.Products.ProdutosServices;
import com.system.SystemERP.Services.Storage.StorageServices;
import com.system.SystemERP.Services.ThirdParties.ThirdPartiesServices;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;

public record ProductionOrderDTO(
        Integer idMaterialType,
        Integer idProduct,
        Integer quantity,
        String label,
        Integer idStorage,
        LocalDate startDate,
        LocalDate endDate,
        Integer idThirdParty
) {
    public ProductionOrder toEntity(MaterialTypeServices materialTypeServices, ProdutosServices produtosServices, StorageServices storageServices, ThirdPartiesServices thirdPartiesServices) {
        return new ProductionOrder(
                null,
                fetchMaterialTypeById(idMaterialType, materialTypeServices),
                fetchProductById(idProduct, produtosServices),
                this.quantity,
                this.label,
                fetchStorageById(idStorage, storageServices),
                this.startDate,
                this.endDate,
                fetchThirdPartyById(idThirdParty, thirdPartiesServices)
        );
    }


    public MaterialType fetchMaterialTypeById(Integer id, MaterialTypeServices materialTypeServices) {
        var entity = materialTypeServices.findByID(id);
        return entity;
    }

    public Product fetchProductById(Integer id, ProdutosServices produtosServices) {
        var entity = produtosServices.getById(id);
        return entity.orElseThrow(() -> new EntityNotFoundException("Produto nao encontrado"));
    }

    public Storage fetchStorageById(Integer id, StorageServices storageServices) {
        var entity = storageServices.getById(id);
        return entity.orElseThrow(() -> new EntityNotFoundException("Armazem nao encontrado"));

    }

    public ThirdParty fetchThirdPartyById(Integer id, ThirdPartiesServices thirdPartiesServices) {
        var entity = thirdPartiesServices.getById(id);
        return entity.orElseThrow(() -> new EntityNotFoundException("Terceiro nao encontrado"));

    }

}
