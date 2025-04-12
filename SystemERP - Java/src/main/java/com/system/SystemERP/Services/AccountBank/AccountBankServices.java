package com.system.SystemERP.Services.AccountBank;


import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Repository.AccountBank.AccountBankRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountBankServices {

    private AccountBankRepository accountBankRepository;

    public AccountBankServices(AccountBankRepository accountBankRepository) {
        this.accountBankRepository = accountBankRepository;
    }

    public AccountBank findByID(Integer Id) {
        return accountBankRepository.findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
    }


}


