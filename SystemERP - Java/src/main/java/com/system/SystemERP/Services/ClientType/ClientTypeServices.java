package com.system.SystemERP.Services.ClientType;

import com.system.SystemERP.Entity.ClientType.ClientType;
import com.system.SystemERP.Repository.ClientType.ClientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientTypeServices {

    @Autowired
    private ClientTypeRepository clientTypeRepository;


    public Optional<ClientType> findByID(Integer Id) {
        return clientTypeRepository.findById(Id);
    }
}
