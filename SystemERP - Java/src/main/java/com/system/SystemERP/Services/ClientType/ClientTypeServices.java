package com.system.SystemERP.Services.ClientType;

import com.system.SystemERP.Entity.ClientType.ClientType;
import com.system.SystemERP.Repository.ClientType.ClientTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientTypeServices {

    private ClientTypeRepository clientTypeRepository;

    public ClientTypeServices(ClientTypeRepository clientTypeRepository) {
        this.clientTypeRepository = clientTypeRepository;
    }

    public ClientType findByID(Integer Id) {
        return clientTypeRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("ClientType nao encontrado"));
    }
}
