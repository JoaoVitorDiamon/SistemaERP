package com.system.SystemERP.Controller.MaterialType;

import com.system.SystemERP.Dtos.MaterialType.MaterialTypeDTO;
import com.system.SystemERP.Entity.MaterialType.MaterialType;
import com.system.SystemERP.Services.MaterialType.MaterialTypeServices;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/materialType")
public class MaterialTypeController {

    public MaterialTypeController(MaterialTypeServices materialTypeServices) {
        this.materialTypeServices = materialTypeServices;
    }

    private MaterialTypeServices materialTypeServices;

    @PostMapping
    public ResponseEntity<String> createMaterialType(@RequestBody MaterialTypeDTO materialTypeDTO) {
        var savedEntity = materialTypeServices.createMaterialType(materialTypeDTO);
        return ResponseEntity.created(URI.create("/materialType" + savedEntity.toString())).build();
    }

    @GetMapping("/{idMaterialType}")
    public ResponseEntity<MaterialType> findByID(@PathVariable Integer idMaterialType) {
        var entity = materialTypeServices.findByID(idMaterialType);
        return ResponseEntity.ok(entity);

    }

    @GetMapping
    public ResponseEntity<List<MaterialType>> getAll() {
        var entityList = materialTypeServices.getAll();
        return ResponseEntity.ok(entityList);
    }

    @DeleteMapping("/{idMaterialType}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idMaterialType) {
        materialTypeServices.DeleteByID(idMaterialType);
        return ResponseEntity.noContent().build();
    }


}
