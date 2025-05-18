package com.system.SystemERP.Dtos.Members;

import com.system.SystemERP.Entity.Members.Members;

public record MembersDTO(
        Integer id,
        String natureMember,
        String gender,
        String telephone,
        String zipCode,
        String dateOfBirth,
        String publicAssociation,
        Integer idUser,
        Integer idEnterprise,
        Integer idPosition
) {
    public static MembersDTO fromEntity(Members member) {
        return new MembersDTO(
                member.getIdMembers(),
                member.getNatureMember(),
                member.getGender(),
                member.getTelephone(),
                member.getZipCode(),
                member.getDateOfBirth(),
                member.getPublicAssociation(),
                member.getUser() != null ? member.getUser().getIDUser() : null,
                member.getEnterprise() != null ? member.getEnterprise().getIdEnterprise() : null,
                member.getPosition() != null ? member.getPosition().getIdPosition() : null
        );
    }
}
