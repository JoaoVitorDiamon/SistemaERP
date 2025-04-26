package com.system.SystemERP.Dtos.Products;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.NatureProduct.NatureProduct;
import com.system.SystemERP.Entity.Products.Product;
import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import com.system.SystemERP.Entity.Size.Size;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import com.system.SystemERP.Services.BarCodeType.BarCodeTypeServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import com.system.SystemERP.Services.NatureProducts.NatureProductsServices;
import com.system.SystemERP.Services.SerialNumberControl.SerialNumberControlService;

public record ProdutosDTO(
        String productName,
        String label,
        boolean sale,
        boolean purchase,
        String barcode,
        String description,
        int stockAlert,
        int desiredStock,
        double weight,
        double length,
        double height,
        double width,
        double volume,
        double area,
        String customsCode,
        String note,
        double price,
        double minimumPrice,
        double ICMS,
        double ICMSTaxRate,
        Integer IdSerialNumberControl,
        Integer IdBarCodeType,
        Integer IdNatureProduct,
        Integer IdSalesCode,
        Integer IdExportCode,
        Integer IdPurchaseCode,
        Integer IdImportCode,
        Integer IdEnterprise
) {
    public Product toEntity(SerialNumberControlService serialNumberControlService, BarCodeTypeServices barCodeTypeServices, NatureProductsServices natureProductsServices, AccountingCodeServices accountingCodeServices, EnterpriseServices enterpriseServices) {
        return new Product(
                null,
                productName,
                label,
                sale,
                fetchSerialNumberControlById(IdSerialNumberControl, serialNumberControlService),
                fetchBarCodeTypeById(IdBarCodeType, barCodeTypeServices),
                purchase,
                barcode,
                description,
                stockAlert,
                desiredStock,
                fetchNatureProductById(IdNatureProduct, natureProductsServices),
                new Size(weight,length,height,width,volume,area),
                customsCode,
                note,
                price,
                minimumPrice,
                ICMS,
                ICMSTaxRate,
                fetchAccountingCodeByID(IdSalesCode, accountingCodeServices),
                fetchAccountingCodeByID(IdExportCode, accountingCodeServices),
                fetchAccountingCodeByID(IdPurchaseCode, accountingCodeServices),
                fetchAccountingCodeByID(IdImportCode, accountingCodeServices),
                fetchEnterpriseById(IdEnterprise, enterpriseServices)
        );
    }

    private SerialNumberControl fetchSerialNumberControlById(Integer id, SerialNumberControlService serialNumberControlService){
        var serialNumberControl = serialNumberControlService.findById(id);
        return serialNumberControl;
    }

    private BarCodeType fetchBarCodeTypeById(Integer id, BarCodeTypeServices barCodeTypeServices){
        var barCodeType = barCodeTypeServices.findById(id);
        return barCodeType;
    }

    private NatureProduct fetchNatureProductById(Integer id, NatureProductsServices natureProductsServices){
        var natureProduct = natureProductsServices.getById(id);
        return natureProduct;
    }

    private AccountingCode fetchAccountingCodeByID(Integer id, AccountingCodeServices accountingCodeServices){
        var accountingCode = accountingCodeServices.findByID(id);
        return accountingCode;
    }

    private Enterprise fetchEnterpriseById(Integer id, EnterpriseServices enterpriseServices){
        var entity = enterpriseServices.findByID(id);
        return entity;
    }
}
