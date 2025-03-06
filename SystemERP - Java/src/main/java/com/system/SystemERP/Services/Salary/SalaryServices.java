package com.system.SystemERP.Services.Salary;

import com.system.SystemERP.Dtos.Salary.SalaryDTO;
import com.system.SystemERP.Entity.Salary.Salary;
import com.system.SystemERP.Repository.Salary.SalaryRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.Members.MembersServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServices {

    @Autowired
    private AccountBankServices accountBankServices;

    @Autowired
    private TypesPaymentsServices typesPaymentsServices;

    @Autowired
    private MembersServices membersServices;

    @Autowired
    private SalaryRepository salaryRepository;


    public Integer createSalary(SalaryDTO salaryDTO){
       var salary = salaryDTO.toEntity(accountBankServices,typesPaymentsServices,membersServices);
        var salaryID = salaryRepository.save(salary);
        return salaryID.getIdSalary();
    }

    public Optional<Salary> findByID(Integer Id){
        return salaryRepository.findById(Id);
    }

    public List<Salary> findAll(){
        return salaryRepository.findAll();
    }

    public void DeleteByID(Integer Id){
       var existsID = salaryRepository.existsById(Id);

       if(existsID){
           salaryRepository.deleteById(Id);
       } else {
           new EntityNotFoundException("Salario Não Encontrado");
       }
    }

    public List<Salary> findByIdEnterprise(Integer Id){
        return salaryRepository.findByMembers_Enterprise_IdEnterprise(Id);
    }

}
