package com.system.SystemERP.Services.MaterialType;

import com.system.SystemERP.Dtos.MaterialType.MaterialTypeDTO;
import com.system.SystemERP.Entity.MaterialType.MaterialType;
import com.system.SystemERP.Repository.MaterialType.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialTypeServices {

    @Autowired
    private MaterialTypeRepository materialTypeRepository;


    public Integer createMaterialType(MaterialTypeDTO materialTypeDTO) {
        var entity = materialTypeDTO.toEntity();
        entity = materialTypeRepository.save(entity);
        return entity.getIdMaterialType();
    }

    public Optional<MaterialType> findByID(Integer Id) {
        return materialTypeRepository.findById(Id);
    }

    public List<MaterialType> getAll() {
        return materialTypeRepository.findAll();
    }

    public void DeleteByID(Integer Id) {
        var exists = materialTypeRepository.existsById(Id);

        if (exists) {
            materialTypeRepository.deleteById(Id);
        }
    }


}
