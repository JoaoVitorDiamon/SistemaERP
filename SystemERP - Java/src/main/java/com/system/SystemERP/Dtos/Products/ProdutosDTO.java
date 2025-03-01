package com.system.SystemERP.Dtos.Products;
import com.system.SystemERP.Entity.Products.Product;

public record ProdutosDTO(
        Integer idProduto,
        String nomeProduto,
        String etiqueta,
        boolean venda,
        boolean compra,
        String codigoDeBarras,
        String descricao,
        int estoqueAlerta,
        int estoqueDesejado,
        double peso,
        double comprimento,
        double altura,
        double largura,
        double volume,
        double area,
        String codigoAlfandegaria,
        String nota,
        double preco,
        double precominimo,
        double icms,
        double taxaICMSP
) {
    public ProdutosDTO {
        volume = comprimento * altura * largura;
        area = comprimento * largura;
    }

    public Product toEntity() {
        return new Product(
                idProduto,
                nomeProduto,
                etiqueta,
                venda,
                compra,
                codigoDeBarras,
                descricao,
                estoqueAlerta,
                estoqueDesejado,
                peso,
                comprimento,
                altura,
                largura,
                codigoAlfandegaria,
                nota,
                preco,
                precominimo,
                icms,
                taxaICMSP
        );
    }
}
