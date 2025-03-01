package com.system.SystemERP.Services.AccountBank;


import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Repository.AccountBank.AccountBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AccountBankServices {

        @Autowired
        private AccountBankRepository accountBankRepository;

    public Optional<AccountBank> findByID(Integer Id) {
        return accountBankRepository.findById(Id);
    }


}


