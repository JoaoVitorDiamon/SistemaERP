package com.system.SystemERP.Entity.Service;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"Services\"")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdService\"")
    private Integer IdService;

    @Column(name = "\"ProductRef\"")
    private String ProductRef;

    @Column(name = "\"Label\"")
    private String Label;

    @Column(name = "\"Sale\"")
    private boolean Sale;

    @Column(name = "\"Purchase\"")
    private boolean Purchase;

    @OneToOne
    @JoinColumn(name = "\"IdSerialNumberControl\"", foreignKey = @ForeignKey(name = "\"FK_IdSerialNumberControl_Service\""))
    private SerialNumberControl SerialNumberControl;

    @OneToOne
    @JoinColumn(name = "\"IdBarCodeType\"", foreignKey = @ForeignKey(name = "\"FK_IdBarCodeType_Service\""))
    private BarCodeType BarCodeType;

    @Column(name = "\"Description\"")
    private String Description;

    @Column(name = "\"Notes\"")
    private String Notes;

    @Column(name = "\"Duration\"")
    private LocalTime Duration;

    @Column(name = "\"Price\"")
    private double Price;

    @Column(name = "\"MinimumPrice\"")
    private double MinimumPrice;

    @Column(name = "\"ICMS\"")
    private int ICMS;

    @Column(name = "\"TaxCMSP\"")
    private double TaxCMSP;

    @OneToOne
    @JoinColumn(name = "\"IdSalesCode\"", foreignKey = @ForeignKey(name = "\"FK_IdSalesCode_Service\""))
    private AccountingCode SalesCode;

    @OneToOne
    @JoinColumn(name = "\"IdExportCode\"", foreignKey = @ForeignKey(name = "\"FK_IdExportCode_Service\""))
    private AccountingCode ExportCode;

    @OneToOne
    @JoinColumn(name = "\"IdImportCode\"", foreignKey = @ForeignKey(name = "\"FK_IdImportCode_Service\""))
    private AccountingCode ImportCode;

    @OneToOne
    @JoinColumn(name = "\"IdPurchaseCode\"", foreignKey = @ForeignKey(name = "\"FK_IdPurchaseCode_Service\""))
    private AccountingCode PurchaseCode;

    @ManyToOne
    @JoinColumn(name = "\"IdEnterprise\"", foreignKey = @ForeignKey(name = "\"FK_IdEnterprise_Service\""))
    private Enterprise Enterprise;

    @ManyToOne
    @JoinColumn(name = "\"IdAddress\"", foreignKey = @ForeignKey(name = "\"FK_IdAddress_Service\""))
    private Adress Adress;

    public Service(Integer idService, String productRef, String label, boolean sale, boolean purchase, com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl serialNumberControl, com.system.SystemERP.Entity.BarCodeType.BarCodeType barCodeType, String description, String notes, LocalTime duration, double price, double minimumPrice, int ICMS, double taxCMSP, AccountingCode salesCode, AccountingCode exportCode, AccountingCode importCode, AccountingCode purchaseCode, com.system.SystemERP.Entity.Enterprise.Enterprise enterprise, com.system.SystemERP.Entity.Adress.Adress adress) {
        IdService = idService;
        ProductRef = productRef;
        Label = label;
        Sale = sale;
        Purchase = purchase;
        SerialNumberControl = serialNumberControl;
        BarCodeType = barCodeType;
        Description = description;
        Notes = notes;
        Duration = duration;
        Price = price;
        MinimumPrice = minimumPrice;
        this.ICMS = ICMS;
        TaxCMSP = taxCMSP;
        SalesCode = salesCode;
        ExportCode = exportCode;
        ImportCode = importCode;
        PurchaseCode = purchaseCode;
        Enterprise = enterprise;
        Adress = adress;
    }
}
