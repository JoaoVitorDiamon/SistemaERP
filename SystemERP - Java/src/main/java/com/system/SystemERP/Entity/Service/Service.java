package com.system.SystemERP.Entity.Service;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "\"IdSerialNumberControl\"")
    private SerialNumberControl SerialNumberControl;

    @OneToOne
    @JoinColumn(name = "\"IdBarCodeType\"")
    private BarCodeType BarCodeType;

    @Column(name = "\"Barcode\"")
    private String Barcode;

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
    @JoinColumn(name = "\"IdSalesCode\"")
    private AccountingCode SalesCode;

    @OneToOne
    @JoinColumn(name = "\"IdExportCode\"")
    private AccountingCode ExportCode;

    @OneToOne
    @JoinColumn(name = "\"IdImportCode\"")
    private AccountingCode ImportCode;

    @OneToOne
    @JoinColumn(name = "\"IdPurchaseCode\"")
    private AccountingCode PurchaseCode;

    @ManyToOne
    @JoinColumn(name = "\"IdEnterprise\"")
    private Enterprise Enterprise;

    @ManyToOne
    @JoinColumn(name = "\"IdAddress\"")
    private Adress Adress;
}
