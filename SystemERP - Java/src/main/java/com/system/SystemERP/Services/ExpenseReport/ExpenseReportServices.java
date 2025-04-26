package com.system.SystemERP.Services.ExpenseReport;


import com.system.SystemERP.Dtos.ExpenseReport.ExpenseReportDTO;
import com.system.SystemERP.Entity.ExpenseReport.ExpenseReport;
import com.system.SystemERP.Exceptions.Custom.InvalidDataException;
import com.system.SystemERP.Repository.ExpenseReport.ExpenseReportRepository;
import com.system.SystemERP.Services.Members.MembersServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        var report = expenseReportDTO.toEntity(membersServices);
        validateDates(report.getInicialDate(), report.getEndDate());
        var saved = expenseReportRepository.save(report);
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


    public void validateDates(LocalDateTime inicialDate, LocalDateTime endDate) {
        LocalDateTime now = LocalDateTime.now();

        if (inicialDate.isBefore(now)) {
            throw new InvalidDataException("A data de término não pode estar no passado. ");
        }

        if (inicialDate.isAfter(now)) {
            throw new InvalidDataException("A data de início não pode estar no futuro. ");
        }
    }
}
