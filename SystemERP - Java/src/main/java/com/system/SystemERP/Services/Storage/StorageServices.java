package com.system.SystemERP.Services.Storage;

import com.system.SystemERP.Dtos.Storage.StorageDTO;
import com.system.SystemERP.Entity.Storage.Storage;
import com.system.SystemERP.Repository.Storage.StorageRepository;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageServices {
    private final StorageRepository storageRepository;
    private final AddresServices addresServices;
    private final EnterpriseServices enterpriseServices;

    public StorageServices(StorageRepository storageRepository, AddresServices addresServices, EnterpriseServices enterpriseServices) {
        this.storageRepository = storageRepository;
        this.addresServices = addresServices;
        this.enterpriseServices = enterpriseServices;
    }

    public Integer createStorage(StorageDTO storageDTO) {
        var storage = storageDTO.toEntity(addresServices, enterpriseServices);
        var savedStorage = storageRepository.save(storage);
        return savedStorage.getStorageId();
    }

    public Optional<Storage> getById(Integer id) {
        return storageRepository.findById(id);
    }

    public List<Storage> getAll() {
        return storageRepository.findAll();
    }

    public void delete(Integer id) {
        storageRepository.deleteById(id);
    }
}
