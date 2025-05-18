package com.system.SystemERP.Services.CollectiveLicense;

import com.system.SystemERP.Dtos.CollectiveLicense.CollectiveLicenseDTO;
import com.system.SystemERP.Entity.CollectiveLicense.CollectiveLicense;
import com.system.SystemERP.Repository.CollectiveLicense.CollectiveLicenseRepository;
import com.system.SystemERP.Services.LicenseType.LicenseTypeServices;
import com.system.SystemERP.Services.Members.MembersServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectiveLicenseService {

    private CollectiveLicenseRepository collectiveLicenseRepository;
    private LicenseTypeServices licenseTypeServices;
    private MembersServices membersServices;

    public CollectiveLicenseService(CollectiveLicenseRepository collectiveLicenseRepository, LicenseTypeServices licenseTypeServices, MembersServices membersServices) {
        this.collectiveLicenseRepository = collectiveLicenseRepository;
        this.licenseTypeServices = licenseTypeServices;
        this.membersServices = membersServices;
    }


    public Integer createCollectiveLicense(CollectiveLicenseDTO collectiveLicenseDTO) {
        var entity = collectiveLicenseDTO.toEntity(licenseTypeServices, membersServices);
        var saved = collectiveLicenseRepository.save(entity);
        return saved.getIdCollectiveLicense();
    }


    public List<CollectiveLicenseDTO> getAllCollectiveLicenses() {
        return collectiveLicenseRepository.findAll().stream()
                .map(CollectiveLicenseDTO::fromEntity)
                .toList();
    }

    public CollectiveLicenseDTO getByIdCollectiveLicense(Integer idCollectiveLicense) {
        return collectiveLicenseRepository.findById(idCollectiveLicense)
                .map(CollectiveLicenseDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Licença não encontrada"));
    }

    public void deleteByIdCollectiveLicense(Integer idCollectiveLicense) {
        var exists = collectiveLicenseRepository.existsById(idCollectiveLicense);
        if (!exists) throw new EntityNotFoundException("Licensa nao encontrada");
        collectiveLicenseRepository.deleteById(idCollectiveLicense);
    }
}
