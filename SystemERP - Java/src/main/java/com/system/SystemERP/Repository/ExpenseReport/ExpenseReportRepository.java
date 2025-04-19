package com.system.SystemERP.Repository.ExpenseReport;

import com.system.SystemERP.Entity.ExpenseReport.ExpenseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseReportRepository extends JpaRepository<ExpenseReport, Integer> {
}
