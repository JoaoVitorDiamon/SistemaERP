package com.system.SystemERP.Services.LicenseType;


import com.system.SystemERP.Dtos.LicenseType.LicenceTypeDTO;
import com.system.SystemERP.Entity.LicenseType.LicenseType;
import com.system.SystemERP.Repository.LicenseType.LicenseTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseTypeServices {


    private LicenseTypeRepository licenseTypeRepository;

    public LicenseTypeServices(LicenseTypeRepository licenseTypeRepository) {
        this.licenseTypeRepository = licenseTypeRepository;
    }

    public Integer createLicenceType(LicenceTypeDTO licenceTypeDTO) {
        var entity = licenceTypeDTO.toEntity();
        entity = licenseTypeRepository.save(entity);
        return entity.getIdLicenseType();
    }

    public LicenseType findByID(Integer Id) {
        return licenseTypeRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Licença nao Encontrada!"));
    }

    public List<LicenseType> getAll() {
        return licenseTypeRepository.findAll();
    }

    public void deleteByID(Integer id) {
        var exists = licenseTypeRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Licença nao Encontrada!");
        licenseTypeRepository.deleteById(id);
    }
}
