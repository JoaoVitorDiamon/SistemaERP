package com.system.SystemERP.Entity.Products;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.NatureProduct.NatureProduct;
import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import com.system.SystemERP.Entity.Size.Size;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"Products\"")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdProduct\"")
    private Integer IdProduct;

    @Column(name = "\"ProductName\"")
    private String ProductName;

    @Column(name = "\"Label\"")
    private String Label;

    @Column(name = "\"Sale\"")
    private boolean Sale;

    @OneToOne
    @JoinColumn(name = "\"SerialNumberControlId\"", foreignKey = @ForeignKey(name = "\"FK_SerialNumberControlId_Products\""))
    private SerialNumberControl SerialNumberControl;

    @OneToOne
    @JoinColumn(name = "\"BarCodeTypeId\"", foreignKey = @ForeignKey(name = "\"FK_BarCodeTypeId_Products\""))
    private BarCodeType BarCodeType;

    @Column(name = "\"Purchase\"")
    private boolean Purchase;

    @Column(name = "\"Barcode\"")
    private String Barcode;

    @Column(name = "\"Description\"")
    private String Description;

    @Column(name = "\"StockAlert\"")
    private int StockAlert;

    @Column(name = "\"DesiredStock\"")
    private int DesiredStock;

    @ManyToOne
    @JoinColumn(name = "\"NatureProductId\"", foreignKey = @ForeignKey(name = "\"FK_NatureProductId_Products\""))
    private NatureProduct NatureProduct;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "Weight", column = @Column(name = "\"Weight\"")),
            @AttributeOverride(name = "Length", column = @Column(name = "\"Length\"")),
            @AttributeOverride(name = "Height", column = @Column(name = "\"Height\"")),
            @AttributeOverride(name = "Width", column = @Column(name = "\"Width\"")),
            @AttributeOverride(name = "Volume", column = @Column(name = "\"Volume\"")),
            @AttributeOverride(name = "Area", column = @Column(name = "\"Area\""))
    })
    private Size Size;

    @Column(name = "\"CustomsCode\"")
    private String CustomsCode;

    @Column(name = "\"Note\"")
    private String Note;

    @Column(name = "\"Price\"")
    private double Price;

    @Column(name = "\"MinimumPrice\"")
    private double MinimumPrice;

    @Column(name = "\"ICMS\"")
    private double ICMS;

    @Column(name = "\"ICMSTaxRate\"")
    private double ICMSTaxRate;

    @ManyToOne
    @JoinColumn(name = "\"SalesCodeId\"", foreignKey = @ForeignKey(name = "\"FK_SalesCodeId_Products\""))
    private AccountingCode SalesCode;

    @ManyToOne
    @JoinColumn(name = "\"ExportCodeId\"", foreignKey = @ForeignKey(name = "\"FK_ExportCodeId_Products\""))
    private AccountingCode ExportCode;

    @ManyToOne
    @JoinColumn(name = "\"PurchaseCodeId\"", foreignKey = @ForeignKey(name = "\"FK_PurchaseCodeId_Products\""))
    private AccountingCode PurchaseCode;

    @ManyToOne
    @JoinColumn(name = "\"ImportCodeId\"", foreignKey = @ForeignKey(name = "\"FK_ImportCodeId_Products\""))
    private AccountingCode ImportCode;

    @ManyToOne
    @JoinColumn(name = "\"EnterpriseId\"", foreignKey = @ForeignKey(name = "\"FK_Enterprise_Products\""))
    private Enterprise Enterprise;

    public Product(Integer idProduct, String productName, String label, boolean sale, com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl serialNumberControl, com.system.SystemERP.Entity.BarCodeType.BarCodeType barCodeType, boolean purchase, String barcode, String description, int stockAlert, int desiredStock, com.system.SystemERP.Entity.NatureProduct.NatureProduct natureProduct, Size size, String customsCode, String note, double price, double minimumPrice, double ICMS, double ICMSTaxRate, AccountingCode salesCode, AccountingCode exportCode, AccountingCode purchaseCode, AccountingCode importCode, com.system.SystemERP.Entity.Enterprise.Enterprise enterprise) {
        IdProduct = idProduct;
        ProductName = productName;
        Label = label;
        Sale = sale;
        SerialNumberControl = serialNumberControl;
        BarCodeType = barCodeType;
        Purchase = purchase;
        Barcode = barcode;
        Description = description;
        StockAlert = stockAlert;
        DesiredStock = desiredStock;
        NatureProduct = natureProduct;
        Size = size;
        CustomsCode = customsCode;
        Note = note;
        Price = price;
        MinimumPrice = minimumPrice;
        this.ICMS = ICMS;
        this.ICMSTaxRate = ICMSTaxRate;
        SalesCode = salesCode;
        ExportCode = exportCode;
        PurchaseCode = purchaseCode;
        ImportCode = importCode;
        Enterprise = enterprise;
    }
}
