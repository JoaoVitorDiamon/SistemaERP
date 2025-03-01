package com.system.SystemERP.Repository.AccountingCode;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingCodeRepository extends JpaRepository<AccountingCode, Integer> {
}
