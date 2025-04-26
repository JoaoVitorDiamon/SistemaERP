package com.system.SystemERP.Dtos.Products;

import com.system.SystemERP.Entity.Products.Product;
import com.system.SystemERP.Entity.Size.Size;

public record ProductResponseDTO(
        Integer idProduct,
        String productName,
        String label,
        boolean sale,
        boolean purchase,
        String barcode,
        String description,
        int stockAlert,
        int desiredStock,
        Size size,
        String customsCode,
        String note,
        double price,
        double minimumPrice,
        double ICMS,
        double ICMSTaxRate
) {
    public static ProductResponseDTO fromEntity(Product product) {
        return new ProductResponseDTO(
                product.getIdProduct(),
                product.getProductName(),
                product.getLabel(),
                product.isSale(),
                product.isPurchase(),
                product.getBarcode(),
                product.getDescription(),
                product.getStockAlert(),
                product.getDesiredStock(),
                product.getSize(),
                product.getCustomsCode(),
                product.getNote(),
                product.getPrice(),
                product.getMinimumPrice(),
                product.getICMS(),
                product.getICMSTaxRate()
        );
    }
}
