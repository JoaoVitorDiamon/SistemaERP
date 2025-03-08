package com.system.SystemERP.Services.Service;


import com.system.SystemERP.Dtos.Service.ServiceDTO;
import com.system.SystemERP.Repository.Service.ServiceRepository;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.BarCodeType.BarCodeTypeServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import com.system.SystemERP.Services.SerialNumberControl.SerialNumberControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServices {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private SerialNumberControlService serialNumberControlService;
    @Autowired
    private BarCodeTypeServices barCodeTypeServices;
    @Autowired
    private AccountingCodeServices accountingCodeServices;
    @Autowired
    private EnterpriseServices enterpriseServices;
    @Autowired
    private AddresServices addresServices;

    public Integer CreateService(ServiceDTO serviceDTO) {
        var service = serviceDTO.toEntity(serialNumberControlService, barCodeTypeServices, accountingCodeServices, enterpriseServices, addresServices);
        var savedService = serviceRepository.save(service);
        return savedService.getIdService();
    }

    public Optional<com.system.SystemERP.Entity.Service.Service> getById(Integer id) {
        return serviceRepository.findById(id);
    }

    public List<com.system.SystemERP.Entity.Service.Service> getAll() {
        return serviceRepository.findAll();
    }

    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }
}
