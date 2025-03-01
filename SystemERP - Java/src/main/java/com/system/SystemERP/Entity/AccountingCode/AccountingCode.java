package com.system.SystemERP.Entity.AccountingCode;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"AccountingCode\"")
@Data

public class AccountingCode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdAccountingCode\"")
    private Integer idAccountingCode;

    @Column(name = "\"AccountingCode\"")
    private String AccountingCode;

    @Column(name = "\"CountingCodeDescription\"")
    private String CountingCodeDescription;

    public AccountingCode() {
    }

    public AccountingCode(Integer id, String accountingCode, String countingCodeDescription) {
        this.idAccountingCode = id;
        this.AccountingCode = accountingCode;
        this.CountingCodeDescription = countingCodeDescription;
    }
}
