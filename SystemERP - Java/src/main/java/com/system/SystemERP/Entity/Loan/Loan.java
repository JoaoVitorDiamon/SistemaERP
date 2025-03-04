package com.system.SystemERP.Entity.Loan;


import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "\"Loan\"")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdLoan\"")
    private Integer IdLoan;

    @Column(name = "\"Capital\"")
    private Double Capital;

    @Column(name = "\"InicialDate\"")
    private Date InicialDate;

    @Column(name = "\"EndDate\"")
    private Date EndDate;

    @Column(name = "\"NumberTerms\"")
    private Integer NumberTerms;


    @Column(name = "\"Type\"")
    private Double Type;

    @Column(name = "\"Insurance\"")
    private Double Insurance;

    @Column(name = "\"Notice\"")
    private String Notice;

    @ManyToOne
    @JoinColumn(name = "\"IdAccountingCode\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountingCode_Loan\""))
    private AccountingCode IdAccountingCode;

    @ManyToOne
    @JoinColumn(name = "\"IdAccountBank\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountBank_Loan\""))
    private AccountBank IdAccountBank;

    @Column(name = "\"ValuePaid\"")
    private Double ValuePaid;

    @Column(name = "\"RemainingValue\"")
    private Double RemainingValue;


    public Loan() {
    }

    public Loan(Integer idLoan, Double capital, Date inicialDate, Date endDate, Integer numberTerms, Double type, Double insurance, String notice, AccountingCode idAccountingCode, AccountBank idAccountBank, Double valuePaid, Double remainingValue) {
        IdLoan = idLoan;
        Capital = capital;
        InicialDate = inicialDate;
        EndDate = endDate;
        NumberTerms = numberTerms;
        Type = type;
        Insurance = insurance;
        Notice = notice;
        IdAccountingCode = idAccountingCode;
        IdAccountBank = idAccountBank;
        ValuePaid = valuePaid;
        RemainingValue = remainingValue;
    }


}
