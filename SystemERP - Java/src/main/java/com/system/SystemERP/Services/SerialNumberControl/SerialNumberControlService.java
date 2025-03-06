package com.system.SystemERP.Services.SerialNumberControl;

import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import com.system.SystemERP.Repository.SerialNumberControl.SerialNumberControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SerialNumberControlService {

    @Autowired
    SerialNumberControlRepository serialNumberControlRepository;

    public Optional<SerialNumberControl> findById(Integer id){ return serialNumberControlRepository.findById(id);}
}
