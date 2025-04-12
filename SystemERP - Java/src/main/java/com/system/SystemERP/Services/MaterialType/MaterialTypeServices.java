package com.system.SystemERP.Services.MaterialType;

import com.system.SystemERP.Dtos.MaterialType.MaterialTypeDTO;
import com.system.SystemERP.Entity.MaterialType.MaterialType;
import com.system.SystemERP.Repository.MaterialType.MaterialTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialTypeServices {

    public MaterialTypeServices(MaterialTypeRepository materialTypeRepository) {
        this.materialTypeRepository = materialTypeRepository;
    }

    private MaterialTypeRepository materialTypeRepository;

    public Integer createMaterialType(MaterialTypeDTO materialTypeDTO) {
        var entity = materialTypeDTO.toEntity();
        entity = materialTypeRepository.save(entity);
        return entity.getIdMaterialType();
    }

    public MaterialType findByID(Integer Id) {
        return materialTypeRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Tipo de Material nao encontrado"));
    }

    public List<MaterialType> getAll() {
        return materialTypeRepository.findAll();
    }

    public void DeleteByID(Integer Id) {
        var exists = materialTypeRepository.existsById(Id);
        if (!exists) throw new EntityNotFoundException("Tipo de Material nao encontrado");
        materialTypeRepository.deleteById(Id);
    }


}
