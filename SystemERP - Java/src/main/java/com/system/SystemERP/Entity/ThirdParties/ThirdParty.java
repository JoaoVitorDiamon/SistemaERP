package com.system.SystemERP.Entity.ThirdParties;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.ClientType.ClientType;
import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"ThirdParties\"")
public class ThirdParty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdThirdParty\"")
    private Integer ThirdPartyId;

    @Column(name = "\"Name\"")
    private String Name;

    @Column(name = "\"TradeName\"")
    private String TradeName;

    @ManyToOne
    @JoinColumn(name = "\"IdClientType\"")
    private ClientType ClientType;

    @Column(name = "\"Supplier\"")
    private boolean Supplier;

    @Column(name = "\"ActiveState\"")
    private boolean ActiveState;

    @ManyToOne
    @JoinColumn(name = "\"IdAddress\"")
    private Adress Address;

    @Column(name = "\"Email\"")
    private String Email;

    @Column(name = "\"TaxOnSales\"")
    private boolean TaxOnSales;

    @Column(name = "\"SecondTax\"")
    private boolean SecondTax;

    @Column(name = "\"Capital\"")
    private double Capital;

    @ManyToOne
    @JoinColumn(name = "\"IdCoin\"")
    private Coin Coin;

    @Column(name = "\"EmployeeCount\"")
    private Integer EmployeeCount;

    @Lob
    @Column(name = "\"Logo\"", length = 1000)
    private byte[] Logo;

    @ManyToOne
    @JoinColumn(name = "\"EnterpriseId\"")
    private Enterprise Enterprise;

    public ThirdParty() {
    }

    public ThirdParty(Integer ThirdPartyId, String Name, String TradeName, ClientType ClientType, boolean Supplier, boolean ActiveState, Adress Address, String Email, boolean TaxOnSales, boolean SecondTax, double Capital, Coin Coin, Integer EmployeeCount, byte[] Logo, Enterprise Enterprise) {
        this.ThirdPartyId = ThirdPartyId;
        this.Name = Name;
        this.TradeName = TradeName;
        this.ClientType = ClientType;
        this.Supplier = Supplier;
        this.ActiveState = ActiveState;
        this.Address = Address;
        this.Email = Email;
        this.TaxOnSales = TaxOnSales;
        this.SecondTax = SecondTax;
        this.Capital = Capital;
        this.Coin = Coin;
        this.EmployeeCount = EmployeeCount;
        this.Logo = Logo;
        this.Enterprise = Enterprise;
    }
}
