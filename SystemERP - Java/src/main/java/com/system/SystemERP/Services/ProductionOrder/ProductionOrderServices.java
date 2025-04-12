package com.system.SystemERP.Services.ProductionOrder;


import com.system.SystemERP.Dtos.ProductionOrder.ProductionOrderDTO;
import com.system.SystemERP.Entity.ProductionOrder.ProductionOrder;
import com.system.SystemERP.Repository.ProductionOrder.ProductionOrderRepositorty;
import com.system.SystemERP.Services.MaterialType.MaterialTypeServices;
import com.system.SystemERP.Services.Products.ProdutosServices;
import com.system.SystemERP.Services.Storage.StorageServices;
import com.system.SystemERP.Services.ThirdParties.ThirdPartiesServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionOrderServices {

    private ProductionOrderRepositorty productionOrderRepositorty;
    private MaterialTypeServices materialTypeServices;
    private ProdutosServices produtosServices;
    private StorageServices storageServices;

    public ProductionOrderServices(ProductionOrderRepositorty productionOrderRepositorty, MaterialTypeServices materialTypeServices, ProdutosServices produtosServices, StorageServices storageServices, ThirdPartiesServices thirdPartiesServices) {
        this.productionOrderRepositorty = productionOrderRepositorty;
        this.materialTypeServices = materialTypeServices;
        this.produtosServices = produtosServices;
        this.storageServices = storageServices;
        this.thirdPartiesServices = thirdPartiesServices;
    }

    private ThirdPartiesServices thirdPartiesServices;

    public Integer createProductionOrder(ProductionOrderDTO productionOrderDTO) {
        var entity = productionOrderDTO.toEntity(materialTypeServices, produtosServices, storageServices, thirdPartiesServices);
        entity = productionOrderRepositorty.save(entity);
        return entity.getIdProductionOrder();
    }

    public ProductionOrder findById(Integer id) {
        return productionOrderRepositorty.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
    }

    public List<ProductionOrder> getAll() {
        return productionOrderRepositorty.findAll();
    }

    public void deleteById(Integer id) {
        var exists = productionOrderRepositorty.existsById(id);
        if (!exists) throw new EntityNotFoundException("Entidade não encontrada");
        productionOrderRepositorty.deleteById(id);
    }


}
