package com.system.SystemERP.Services.Service;


import com.system.SystemERP.Dtos.Service.ServiceDTO;
import com.system.SystemERP.Repository.Service.ServiceRepository;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.BarCodeType.BarCodeTypeServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import com.system.SystemERP.Services.SerialNumberControl.SerialNumberControlService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServices {

    private ServiceRepository serviceRepository;
    private SerialNumberControlService serialNumberControlService;
    private BarCodeTypeServices barCodeTypeServices;
    private AccountingCodeServices accountingCodeServices;
    private EnterpriseServices enterpriseServices;
    private AddresServices addresServices;

    public ServiceServices(ServiceRepository serviceRepository, SerialNumberControlService serialNumberControlService, BarCodeTypeServices barCodeTypeServices, AccountingCodeServices accountingCodeServices, EnterpriseServices enterpriseServices, AddresServices addresServices) {
        this.serviceRepository = serviceRepository;
        this.serialNumberControlService = serialNumberControlService;
        this.barCodeTypeServices = barCodeTypeServices;
        this.accountingCodeServices = accountingCodeServices;
        this.enterpriseServices = enterpriseServices;
        this.addresServices = addresServices;
    }

    public Integer CreateService(ServiceDTO serviceDTO) {
        var service = serviceDTO.toEntity(serialNumberControlService, barCodeTypeServices, accountingCodeServices, enterpriseServices, addresServices);
        var savedService = serviceRepository.save(service);
        return savedService.getIdService();
    }

    public com.system.SystemERP.Entity.Service.Service getById(Integer id) {
        return serviceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Servico nao encontrado"));
    }

    public List<com.system.SystemERP.Entity.Service.Service> getAll() {
        return serviceRepository.findAll();
    }

    public void delete(Integer id) {
        var exists = serviceRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Servico nao encontrado");
        serviceRepository.deleteById(id);
    }
}
