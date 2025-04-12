package com.system.SystemERP.Services.AccountingCode;

import com.system.SystemERP.Dtos.AccountingCode.AccountingCodeDTO;
import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Repository.AccountingCode.AccountingCodeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingCodeServices {

    private AccountingCodeRepository accountingCodeRepository;

    public AccountingCodeServices(AccountingCodeRepository accountingCodeRepository) {
        this.accountingCodeRepository = accountingCodeRepository;
    }

    public Integer createAccountingCode(AccountingCodeDTO accountingCodeDTO) {

        System.out.println(accountingCodeDTO.accountingCode().name());

        var conversionAccountingCode = new AccountingCode(
                null,
                accountingCodeDTO.accountingCode().name(),
                accountingCodeDTO.accountingCodeDescription().name());

        var created = accountingCodeRepository.save(conversionAccountingCode);

        return created.getIdAccountingCode();
    }

    public AccountingCode findByID(Integer id) {
        return accountingCodeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade nao encontrada"));

    }

    public List<AccountingCode> findAll() {
        return accountingCodeRepository.findAll();
    }

    public void deleteByID(Integer id) {
        var accountingCodePresent = accountingCodeRepository.existsById(id);
        if (!accountingCodePresent) throw new EntityNotFoundException("Entidade nao encontrada");
        accountingCodeRepository.deleteById(id);
    }


}
