package com.system.SystemERP.Controller.Storage;

import com.system.SystemERP.Dtos.Storage.StorageDTO;
import com.system.SystemERP.Entity.Storage.Storage;
import com.system.SystemERP.Services.Storage.StorageServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/storages")
@Tag(name = "Armazéns")
@Controller
public class StorageController {

    private final StorageServices storageServices;

    public StorageController(StorageServices storageServices) {
        this.storageServices = storageServices;
    }

    @PostMapping
    @Operation(summary = "Cria um armazém", description = "Cria um novo armazém")
    public ResponseEntity<Storage> createStorage(@RequestBody StorageDTO storageDTO) {
        var created = storageServices.createStorage(storageDTO);
        return ResponseEntity.created(URI.create("/storages/" + created)).build();
    }

    @GetMapping("/{idArmazem}")
    @Operation(summary = "Busca um armazém pelo ID", description = "Retorna um armazém pelo ID")
    public ResponseEntity<Storage> findById(@PathVariable Integer idArmazem) {
        var exist = storageServices.getById(idArmazem);
        return ResponseEntity.ok(exist);
    }

    @GetMapping
    @Operation(summary = "Busca todos os armazéns", description = "Retorna uma lista de todos os armazéns")
    public ResponseEntity<List<Storage>> findAll() {
        var listStorages = storageServices.getAll();
        return ResponseEntity.ok(listStorages);
    }

    @DeleteMapping("/{idArmazem}")
    @Operation(summary = "Deleta um armazém pelo ID", description = "Remove um armazém pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Integer idArmazem) {
        storageServices.delete(idArmazem);
        return ResponseEntity.noContent().build();
    }
}
