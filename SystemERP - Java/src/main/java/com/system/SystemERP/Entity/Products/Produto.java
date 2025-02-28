package com.system.SystemERP.Entity.Products;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"produtos\"")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProduto;
    private String nomeProduto;
    private String etiqueta;
    private boolean venda;
    private boolean compra;
    private String codigoDeBarras;
    private String descricao;
    private int estoqueAlerta;
    private int estoqueDesejado;
    private double peso;
    private double comprimento;
    private double altura;
    private double largura;
    private double volume;
    private double area;
    private String codigoAlfandegaria;
    private String nota;
    private double preco;
    private double precominimo;
    private double icms;
    private double taxaICMSP;

    // Construtor completo
    public Produto(Integer idProduto, String nomeProduto, String etiqueta, boolean venda, boolean compra, String codigoDeBarras, String descricao, int estoqueAlerta, int estoqueDesejado, double peso, double comprimento, double altura, double largura, String codigoAlfandegaria, String nota, double preco, double precominimo, double icms, double taxaICMSP) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.etiqueta = etiqueta;
        this.venda = venda;
        this.compra = compra;
        this.codigoDeBarras = codigoDeBarras;
        this.descricao = descricao;
        this.estoqueAlerta = estoqueAlerta;
        this.estoqueDesejado = estoqueDesejado;
        this.peso = peso;
        this.comprimento = comprimento;
        this.altura = altura;
        this.largura = largura;
        this.volume = comprimento * altura * largura;
        this.area = comprimento * largura;
        this.codigoAlfandegaria = codigoAlfandegaria;
        this.nota = nota;
        this.preco = preco;
        this.precominimo = precominimo;
        this.icms = icms;
        this.taxaICMSP = taxaICMSP;
    }
}
