package com.system.SystemERP.Services.Service;


import com.system.SystemERP.Dtos.Service.ServiceDTO;
import com.system.SystemERP.Entity.Service.Servicos;
import com.system.SystemERP.Repository.Service.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServices {
    private ServiceRepository serviceRepository;

    public ServiceServices(ServiceRepository serviceRepository){this.serviceRepository = serviceRepository;}

    public Integer CreateService(ServiceDTO serviceDTO){
        var service = serviceDTO.toEntity();
        var savedService = serviceRepository.save(service);
        return savedService.getIdServico();
    }

    public Optional<Servicos> getById(Integer id){
        return serviceRepository.findById(id);
    }

    public List<Servicos> getAll(){
        return serviceRepository.findAll();
    }

    public void delete(Integer id){
        serviceRepository.deleteById(id);
    }
}
