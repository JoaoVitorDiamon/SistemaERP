package com.system.SystemERP.Services.Position;


import com.system.SystemERP.Entity.Position.Position;
import com.system.SystemERP.Repository.Position.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionServices {

    @Autowired
    private PositionRepository positionRepository;


    public Optional<Position> findByID(Integer id) {
        return positionRepository.findById(id);
    }

}
