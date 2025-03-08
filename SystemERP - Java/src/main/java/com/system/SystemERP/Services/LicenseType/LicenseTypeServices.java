package com.system.SystemERP.Services.LicenseType;


import com.system.SystemERP.Dtos.LicenseType.LicenceTypeDTO;
import com.system.SystemERP.Entity.LicenseType.LicenseType;
import com.system.SystemERP.Repository.LicenseType.LicenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseTypeServices {

    @Autowired
    private LicenseTypeRepository licenseTypeRepository;


    public Integer createLicenceType(LicenceTypeDTO licenceTypeDTO) {
        var entity = licenceTypeDTO.toEntity();
        entity = licenseTypeRepository.save(entity);
        return entity.getIdLicenseType();
    }

    public Optional<LicenseType> findByID(Integer Id) {
        return licenseTypeRepository.findById(Id);
    }

    public List<LicenseType> getAll() {
        return licenseTypeRepository.findAll();
    }

    public void deleteByID(Integer id) {
        var exists = licenseTypeRepository.existsById(id);

        if (exists) {
            licenseTypeRepository.deleteById(id);
        }
    }
}
