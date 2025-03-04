package com.system.SystemERP.Repository.Loan;

import com.system.SystemERP.Entity.Loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
