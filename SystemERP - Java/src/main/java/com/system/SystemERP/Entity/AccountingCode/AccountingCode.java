package com.system.SystemERP.Entity.AccountingCode;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "codigo_contabil")
@Data

public class AccountingCode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String accountingCode;

    private String countingCodeDescription;

    public AccountingCode() {
    }

    public AccountingCode(Integer id, String accountingCode, String countingCodeDescription) {
        this.id = id;
        this.accountingCode = accountingCode;
        this.countingCodeDescription = countingCodeDescription;
    }
}
