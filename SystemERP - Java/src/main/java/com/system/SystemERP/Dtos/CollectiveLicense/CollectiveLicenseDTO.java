package com.system.SystemERP.Dtos.CollectiveLicense;

import com.system.SystemERP.Dtos.Members.MembersDTO;
import com.system.SystemERP.Entity.CollectiveLicense.CollectiveLicense;
import com.system.SystemERP.Entity.LicenseType.LicenseType;
import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Services.LicenseType.LicenseTypeServices;
import com.system.SystemERP.Services.Members.MembersServices;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public record CollectiveLicenseDTO(
        int idTypeLicense,
        Date inicalDate,
        Date endDate,
        int idManager,
        String description,
        List<MembersDTO> members
) {
    public static CollectiveLicenseDTO fromEntity(CollectiveLicense entity) {
        return new CollectiveLicenseDTO(
                entity.getLicenseType().getIdLicenseType(),
                entity.getInicialDate(),
                entity.getEndDate(),
                entity.getIdManager().getIdMembers(),
                entity.getDescription(),
                entity.getMembers().stream()
                        .map(MembersDTO::fromEntity)
                        .collect(Collectors.toList())
        );
    }

    public CollectiveLicense toEntity(LicenseTypeServices licenseTypeServices, MembersServices membersServices) {
        LicenseType licenseType = licenseTypeServices.findByID(idTypeLicense);
        Members manager = membersServices.findById(idManager);

        List<Members> memberList = members.stream()
                .map(membersDTO -> membersServices.findById(membersDTO.id()))  // Aqui usamos o ID do DTO para buscar a entidade Members
                .collect(Collectors.toList());

        return new CollectiveLicense(
                null,
                licenseType,
                inicalDate,
                endDate,
                manager,
                description,
                memberList
        );
    }
}
