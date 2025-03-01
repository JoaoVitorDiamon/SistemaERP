package com.system.SystemERP.Entity.Products;

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

    @Column(name = "\"Weight\"")
    private double Weight;

    @Column(name = "\"Length\"")
    private double Length;

    @Column(name = "\"Height\"")
    private double Height;

    @Column(name = "\"Width\"")
    private double Width;

    @Column(name = "\"Volume\"")
    private double Volume;

    @Column(name = "\"Area\"")
    private double Area;

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

    // Full constructor
    public Product(Integer ProductId, String ProductName, String Label, boolean Sale, boolean Purchase, String Barcode, String Description, int StockAlert, int DesiredStock, double Weight, double Length, double Height, double Width, String CustomsCode, String Note, double Price, double MinimumPrice, double ICMS, double ICMSTaxRate) {
        this.IdProduct = ProductId;
        this.ProductName = ProductName;
        this.Label = Label;
        this.Sale = Sale;
        this.Purchase = Purchase;
        this.Barcode = Barcode;
        this.Description = Description;
        this.StockAlert = StockAlert;
        this.DesiredStock = DesiredStock;
        this.Weight = Weight;
        this.Length = Length;
        this.Height = Height;
        this.Width = Width;
        this.Volume = Length * Height * Width;
        this.Area = Length * Width;
        this.CustomsCode = CustomsCode;
        this.Note = Note;
        this.Price = Price;
        this.MinimumPrice = MinimumPrice;
        this.ICMS = ICMS;
        this.ICMSTaxRate = ICMSTaxRate;
    }
}
