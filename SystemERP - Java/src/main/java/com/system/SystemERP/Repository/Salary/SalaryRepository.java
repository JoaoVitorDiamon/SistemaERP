package com.system.SystemERP.Repository.Salary;

import com.system.SystemERP.Entity.Salary.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    List<Salary> findByMembers_Enterprise_IdEnterprise(Integer idEnterprise);
}
