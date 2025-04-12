package com.system.SystemERP.Controller.LicenseType;

import com.system.SystemERP.Dtos.LicenseType.LicenceTypeDTO;
import com.system.SystemERP.Entity.LicenseType.LicenseType;
import com.system.SystemERP.Services.LicenseType.LicenseTypeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/license")
public class LicenseTypeController {
    private LicenseTypeServices licenseTypeServices;

    public LicenseTypeController(LicenseTypeServices licenseTypeServices) {
        this.licenseTypeServices = licenseTypeServices;
    }



    @PostMapping
    public ResponseEntity<LicenseType> createLicenseType(@RequestBody LicenceTypeDTO licenceTypeDTO) {
        var entity = licenseTypeServices.createLicenceType(licenceTypeDTO);
        return ResponseEntity.created(URI.create("/license" + entity.toString())).build();
    }

    @GetMapping("/{IdLicense}")
    public ResponseEntity<LicenseType> findByID(@PathVariable Integer IdLicense) {
        var entity = licenseTypeServices.findByID(IdLicense);
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<List<LicenseType>> getAll() {
        var entityList = licenseTypeServices.getAll();
        return ResponseEntity.ok(entityList);
    }

    @DeleteMapping("/{IdLicense}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer IdLicense) {
        licenseTypeServices.deleteByID(IdLicense);
        return ResponseEntity.noContent().build();
    }
}
