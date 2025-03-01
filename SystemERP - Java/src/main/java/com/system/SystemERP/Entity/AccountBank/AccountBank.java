package com.system.SystemERP.Entity.AccountBank;
import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Entity.TypeAccount.TypeAccount;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
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
        @JoinColumn(name = "IdAccountType")
        private TypeAccount AccountType;

        @ManyToOne
        @JoinColumn(name = "\"IdCoin\"")
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
        @JoinColumn(name = "IdAccountingCode")
        private AccountingCode AccountingCode;

}
