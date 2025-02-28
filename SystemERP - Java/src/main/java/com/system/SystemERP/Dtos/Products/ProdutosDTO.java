package com.system.SystemERP.Dtos.Products;
import com.system.SystemERP.Entity.Products.Produto;

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

    public Produto toEntity() {
        return new Produto(
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
