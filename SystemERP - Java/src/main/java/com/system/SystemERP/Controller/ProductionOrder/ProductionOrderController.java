package com.system.SystemERP.Controller.ProductionOrder;

import com.system.SystemERP.Dtos.ProductionOrder.ProductionOrderDTO;
import com.system.SystemERP.Entity.ProductionOrder.ProductionOrder;
import com.system.SystemERP.Services.ProductionOrder.ProductionOrderServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productionOrder")
public class ProductionOrderController {

    private ProductionOrderServices productionOrderServices;

    public ProductionOrderController(ProductionOrderServices productionOrderServices) {
        this.productionOrderServices = productionOrderServices;
    }



    @PostMapping
    public ResponseEntity<String> createProductionOrder(@RequestBody ProductionOrderDTO productionOrderDTO) {
        var entity = productionOrderServices.createProductionOrder(productionOrderDTO);
        return ResponseEntity.created(URI.create("/productionOrder" + entity.toString())).build();
    }

    @GetMapping("/{idProductionOrder}")
    public ResponseEntity<ProductionOrder> findById(@PathVariable Integer idProductionOrder) {
        var entity = productionOrderServices.findById(idProductionOrder);
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<List<ProductionOrder>> getAll() {
        var entityList = productionOrderServices.getAll();
        return ResponseEntity.ok(entityList);
    }

    @DeleteMapping("/{idProductionOrder}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idProductionOrder) {
        productionOrderServices.deleteById(idProductionOrder);
        return ResponseEntity.noContent().build();
    }
}
