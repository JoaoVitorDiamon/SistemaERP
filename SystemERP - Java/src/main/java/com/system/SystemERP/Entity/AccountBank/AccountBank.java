package com.system.SystemERP.Entity.AccountBank;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Entity.TypeAccount.TypeAccount;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data

@Table(name = "\"FinancialAccounts\"")
public class AccountBank {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "\"IdFinancialAccounts\"")
        private Integer IdFinancialAccounts;

        @Column(name = "\"LabelBank\"")
        private String LabelBank;


        @Column(name = "\"FinancialAccounts\"")
        private String FinancialAccounts;

        @ManyToOne
        @JoinColumn(name = "\"IdAccountType\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountType_AccountBank\""))
        private TypeAccount AccountType;

        @ManyToOne
        @JoinColumn(name = "\"IdCoin\"", foreignKey = @ForeignKey(name = "\"FK_IdCoin_AccountBank\""))
        private Coin Coin;

        @Column(name = "\"StateActivity\"")
        private Boolean StateActivity;

        @Column(name = "\"Country\"")
        private String Country;

        @Column(name = "\"State\"")
        private String State;

        @Column(name = "\"Address\"")
        private String Address;

        @Column(name = "\"Comment\"")
        private String Comment;

        @Column(name = "\"InitialBalance\n\"")
        private Double InitialBalance;

        @Column(name = "\"Date\"")
        private Date Date;

        @Column(name = "\"MinimumBalance\n\"")
        private BigDecimal MinimumBalance;

        @Column(name = "\"MinimumDesiredBalance\"")
        private BigDecimal MinimumDesiredBalance;

        @Column(name = "\"AccountNumber\n\"")
        private String AccountNumber;

        @Column(name = "\"Holder\"")
        private String Holder;

        @Column(name = "\"AddressHolder\"")
        private String AddressHolder;

        @Column(name = "\"CEP\"")
        private String Cep;

        @ManyToOne
        @JoinColumn(name = "\"IdAccountingCode\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountingCode_AccountBank\""))
        private AccountingCode AccountingCode;

        public AccountBank(Integer idFinancialAccounts, String labelBank, String financialAccounts, TypeAccount accountType, com.system.SystemERP.Entity.Coin.Coin coin, Boolean stateActivity, String country, String state, String address, String comment, Double initialBalance, java.util.Date date, BigDecimal minimumBalance, BigDecimal minimumDesiredBalance, String accountNumber, String holder, String addressHolder, String cep, com.system.SystemERP.Entity.AccountingCode.AccountingCode accountingCode) {
                IdFinancialAccounts = idFinancialAccounts;
                LabelBank = labelBank;
                FinancialAccounts = financialAccounts;
                AccountType = accountType;
                Coin = coin;
                StateActivity = stateActivity;
                Country = country;
                State = state;
                Address = address;
                Comment = comment;
                InitialBalance = initialBalance;
                Date = date;
                MinimumBalance = minimumBalance;
                MinimumDesiredBalance = minimumDesiredBalance;
                AccountNumber = accountNumber;
                Holder = holder;
                AddressHolder = addressHolder;
                Cep = cep;
                AccountingCode = accountingCode;
        }

        public AccountBank() {
        }


}
