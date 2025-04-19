package com.system.SystemERP.Dtos.ExpenseReport;

import com.system.SystemERP.Entity.ExpenseReport.ExpenseReport;
import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Services.Members.MembersServices;

import java.util.Date;

public record ExpenseReportDTO(
        Date inicialDate,
        Date endDate,
        Integer idMembers,
        Integer idResponsable,
        String note
) {

    public ExpenseReport toEntity(MembersServices membersServices){
        return new ExpenseReport(
                null,
                inicialDate,
                endDate,
                fetchMemberById(idMembers,membersServices),
                fetchMemberById(idResponsable,membersServices),
                note
        );

    }

    private Members fetchMemberById(Integer memberID, MembersServices membersServices){
        var members = membersServices.findById(memberID);
        return members;

    }
}
