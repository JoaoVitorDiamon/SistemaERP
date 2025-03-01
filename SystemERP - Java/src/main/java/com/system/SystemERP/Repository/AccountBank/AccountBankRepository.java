package com.system.SystemERP.Repository.AccountBank;

import com.system.SystemERP.Entity.AccountBank.AccountBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBankRepository extends JpaRepository<AccountBank, Integer> {
}
