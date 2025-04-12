package com.system.SystemERP.Services.SerialNumberControl;

import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import com.system.SystemERP.Repository.SerialNumberControl.SerialNumberControlRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SerialNumberControlService {

    SerialNumberControlRepository serialNumberControlRepository;

    public SerialNumberControlService(SerialNumberControlRepository serialNumberControlRepository) {
        this.serialNumberControlRepository = serialNumberControlRepository;
    }

    public SerialNumberControl findById(Integer id){ return serialNumberControlRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Codigo de Serie nao encontrado"));}
}
