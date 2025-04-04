package com.system.SystemERP.Dtos.JobVacancy;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.JobVacancy.JobVacancy;
import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Entity.Position.Position;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.Members.MembersServices;
import com.system.SystemERP.Services.Position.PositionServices;
import jakarta.persistence.EntityNotFoundException;

import java.util.Date;

public record JobVacancyDTO(
        Integer idPosition,
        Integer idResponsable,
        Integer idSupervisor,
        Integer idAdress,
        Date expectedDate,
        Double salary,
        String description
) {

    public JobVacancy toEntity(PositionServices positionServices, MembersServices membersServices, AddresServices addresServices) {
        return new JobVacancy(
                null,
                fetchPositionByID(idPosition, positionServices),
                fetchMemberById(idResponsable, membersServices),
                fetchMemberById(idSupervisor, membersServices),
                fetchAdressByID(idAdress, addresServices),
                expectedDate,
                salary,
                description
        );

    }


    private Members fetchMemberById(Integer memberID, MembersServices membersServices) {
        var members = membersServices.findById(memberID);
        return members.orElseThrow(() -> new EntityNotFoundException("Membro nao Encontrado"));

    }

    private Adress fetchAdressByID(Integer Id, AddresServices addresServices) {
        var addres = addresServices.findByID(Id);
        return addres.orElseThrow(
                () -> new EntityNotFoundException("Endereço nao encontrado"));
    }


    private Position fetchPositionByID(Integer id, PositionServices positionServices) {
        var position = positionServices.findByID(id);
        return position.orElseThrow(
                () -> new EntityNotFoundException("Cargo nao encontrado"));

    }


}
