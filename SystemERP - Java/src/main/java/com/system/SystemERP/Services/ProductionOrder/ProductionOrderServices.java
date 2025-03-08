package com.system.SystemERP.Services.ProductionOrder;


import com.system.SystemERP.Dtos.ProductionOrder.ProductionOrderDTO;
import com.system.SystemERP.Entity.ProductionOrder.ProductionOrder;
import com.system.SystemERP.Repository.ProductionOrder.ProductionOrderRepositorty;
import com.system.SystemERP.Services.MaterialType.MaterialTypeServices;
import com.system.SystemERP.Services.Products.ProdutosServices;
import com.system.SystemERP.Services.Storage.StorageServices;
import com.system.SystemERP.Services.ThirdParties.ThirdPartiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionOrderServices {

    @Autowired
    private ProductionOrderRepositorty productionOrderRepositorty;

    @Autowired
    private MaterialTypeServices materialTypeServices;

    @Autowired
    private ProdutosServices produtosServices;

    @Autowired
    private StorageServices storageServices;

    @Autowired
    private ThirdPartiesServices thirdPartiesServices;

    public Integer createProductionOrder(ProductionOrderDTO productionOrderDTO) {
        var entity = productionOrderDTO.toEntity(materialTypeServices, produtosServices, storageServices, thirdPartiesServices);
        entity = productionOrderRepositorty.save(entity);
        return entity.getIdProductionOrder();
    }

    public Optional<ProductionOrder> findById(Integer id) {
        return productionOrderRepositorty.findById(id);
    }

    public List<ProductionOrder> getAll() {
        return productionOrderRepositorty.findAll();
    }

    public void deleteById(Integer id) {
        var exists = productionOrderRepositorty.existsById(id);
        if (exists) {
            productionOrderRepositorty.deleteById(id);
        }
    }


}
