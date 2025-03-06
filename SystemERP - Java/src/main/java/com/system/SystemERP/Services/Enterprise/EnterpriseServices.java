package com.system.SystemERP.Services.Enterprise;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Repository.Enterprise.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnterpriseServices {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public Optional<Enterprise> findByID(Integer Id) {
        return enterpriseRepository.findById(Id);
    }
}
