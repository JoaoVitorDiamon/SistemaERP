package com.system.SystemERP.Dtos.Storage;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.Storage.Storage;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;


public record StorageDTO(
    String Name,
    String Description,
    String Phone,
    Integer AddressId,
    Integer EnterpriseId
){
    public Storage toEntity(AddresServices addresServices, EnterpriseServices enterpriseServices) {
        return new Storage(
                null,
                Name,
                Description,
                Phone,
                fetchAdressById(AddressId, addresServices),
                fetchEnterpriseById(EnterpriseId, enterpriseServices)
        );
    }
    private Adress fetchAdressById(Integer id, AddresServices addresServices){
        var addres = addresServices.findByID(id);
        return addres.orElseThrow(
                () -> new EntityNotFoundException("Endereco nao encontrado"));
    }

    private Enterprise fetchEnterpriseById(Integer id, EnterpriseServices enterpriseServices){
        var enterprise = enterpriseServices.findByID(id);
        return enterprise.orElseThrow(
                () -> new EntityNotFoundException("Empresa não encontrada"));
    }
}
