package com.system.SystemERP.Services.Position;


import com.system.SystemERP.Entity.Position.Position;
import com.system.SystemERP.Repository.Position.PositionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PositionServices {

    private PositionRepository positionRepository;

    public PositionServices(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position findByID(Integer id) {
        return positionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo nao encontrado"));
    }

}
