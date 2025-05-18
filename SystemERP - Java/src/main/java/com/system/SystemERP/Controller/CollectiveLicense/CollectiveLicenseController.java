package com.system.SystemERP.Controller.CollectiveLicense;


import com.system.SystemERP.Dtos.CollectiveLicense.CollectiveLicenseDTO;
import com.system.SystemERP.Entity.CollectiveLicense.CollectiveLicense;
import com.system.SystemERP.Services.CollectiveLicense.CollectiveLicenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/collectiveLicense")
@RestController
public class CollectiveLicenseController {

    private CollectiveLicenseService collectiveLicenseService;

    public CollectiveLicenseController(CollectiveLicenseService collectiveLicenseService) {
        this.collectiveLicenseService = collectiveLicenseService;
    }

    @PostMapping
    public ResponseEntity<String> addCollectiveLicense(@RequestBody CollectiveLicenseDTO collectiveLicense) {
        var entitySaved = collectiveLicenseService.createCollectiveLicense(collectiveLicense);
        return ResponseEntity.created(URI.create("/" + entitySaved.toString())).build();
    }

    @GetMapping("/{idCollectiveLicense}")
    public ResponseEntity<CollectiveLicenseDTO> getCollectiveLicenseById(@PathVariable("idCollectiveLicense") Integer idCollectiveLicense) {
        var entity = collectiveLicenseService.getByIdCollectiveLicense(idCollectiveLicense);
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<List<CollectiveLicenseDTO>> getCollectiveLicenses() {
        var entity = collectiveLicenseService.getAllCollectiveLicenses();
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{idCollectiveLicense}")
    public ResponseEntity<Void> deleteCollectiveLicense(@PathVariable("idCollectiveLicense") Integer idCollectiveLicense) {
        collectiveLicenseService.deleteByIdCollectiveLicense(idCollectiveLicense);
        return ResponseEntity.noContent().build();
    }
}
