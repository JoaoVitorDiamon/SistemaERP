package com.system.SystemERP.Services.ExpenseReport;


import com.system.SystemERP.Dtos.ExpenseReport.ExpenseReportDTO;
import com.system.SystemERP.Entity.ExpenseReport.ExpenseReport;
import com.system.SystemERP.Repository.ExpenseReport.ExpenseReportRepository;
import com.system.SystemERP.Services.Members.MembersServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseReportServices {

    private MembersServices membersServices;
    private ExpenseReportRepository expenseReportRepository;

    public ExpenseReportServices(MembersServices membersServices, ExpenseReportRepository expenseReportRepository) {
        this.membersServices = membersServices;
        this.expenseReportRepository = expenseReportRepository;
    }

    public Integer createExpenseReport(ExpenseReportDTO expenseReportDTO) {
        var entity = expenseReportDTO.toEntity(membersServices);
        var saved = expenseReportRepository.save(entity);
        return saved.getIdExpenseReport();
    }

    public ExpenseReport findById(Integer id) {
        return expenseReportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Relatorio nao encontrado"));
    }

    public List<ExpenseReport> findAll() {
        return expenseReportRepository.findAll();
    }

    public void deleteById(Integer id) {
        var exists = expenseReportRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Relatorio nao encontrado");
        expenseReportRepository.deleteById(id);
    }

}
