package com.system.SystemERP.Services.Enterprise;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Repository.Enterprise.EnterpriseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseServices {

    private EnterpriseRepository enterpriseRepository;

    public EnterpriseServices(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    public Enterprise findByID(Integer Id) {
        return enterpriseRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Empresa nao encontrada"));
    }
}
