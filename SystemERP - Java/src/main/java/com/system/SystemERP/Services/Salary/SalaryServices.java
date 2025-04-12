package com.system.SystemERP.Services.Salary;

import com.system.SystemERP.Dtos.Salary.SalaryDTO;
import com.system.SystemERP.Entity.Salary.Salary;
import com.system.SystemERP.Repository.Salary.SalaryRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.Members.MembersServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServices {

    private AccountBankServices accountBankServices;
    private TypesPaymentsServices typesPaymentsServices;
    private MembersServices membersServices;
    private SalaryRepository salaryRepository;

    public SalaryServices(AccountBankServices accountBankServices, TypesPaymentsServices typesPaymentsServices, MembersServices membersServices, SalaryRepository salaryRepository) {
        this.accountBankServices = accountBankServices;
        this.typesPaymentsServices = typesPaymentsServices;
        this.membersServices = membersServices;
        this.salaryRepository = salaryRepository;
    }

    public Integer createSalary(SalaryDTO salaryDTO) {
        var salary = salaryDTO.toEntity(accountBankServices, typesPaymentsServices, membersServices);
        var salaryID = salaryRepository.save(salary);
        return salaryID.getIdSalary();
    }

    public Salary findByID(Integer Id) {
        return salaryRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Salario nao encontrado"));
    }

    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }

    public void DeleteByID(Integer Id) {
        var existsID = salaryRepository.existsById(Id);
        if (!existsID) throw new EntityNotFoundException("Salario nao encontrado");
        salaryRepository.deleteById(Id);
    }

    public List<Salary> findByIdEnterprise(Integer Id) {
        return salaryRepository.findByMembers_Enterprise_IdEnterprise(Id);
    }

}
