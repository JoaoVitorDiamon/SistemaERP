package com.system.SystemERP.Entity.Products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "produtos")
public class Produto {

    public Produto() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProduto;

    private String nomeProduto;


//    private String etiqueta;
//    private boolean venda;
//    private boolean compra;
//    private String codigoDeBarras;
//    private String descricao;
//    private int estoqueAlerta;
//    private int estoqueDesejado;
//    private double peso;
//    private double comprimento;
//    private double altura;
//    private double largura;
//    private double volume = comprimento * altura * largura;
//    private double area = comprimento * largura;
//    private String codigoAlfandegaria;
//    private String pais;
//    private String estado;
//    private String nota;
//    private double preco;
//    private double precominimo;
//    private double icms;
//    private double taxaICMSP;


    public Produto(Integer idProduto, String nomeProduto /*String etiqueta, boolean venda, boolean compra, String codigoDeBarras, String descricao, int estoqueAlerta, int estoqueDesejado, double peso, double comprimento, double altura, double largura, double volume, double area, String codigoAlfandegaria, String pais, String estado, String nota, double preco, double precominimo, double icms, double taxaICMSP) */){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
//        this.etiqueta = etiqueta;
//        this.venda = venda;
//        this.compra = compra;
//        this.codigoDeBarras = codigoDeBarras;
//        this.descricao = descricao;
//        this.estoqueAlerta = estoqueAlerta;
//        this.estoqueDesejado = estoqueDesejado;
//        this.peso = peso;
//        this.comprimento = comprimento;
//        this.altura = altura;
//        this.largura = largura;
//        this.volume = volume;
//        this.area = area;
//        this.codigoAlfandegaria = codigoAlfandegaria;
//        this.pais = pais;
//        this.estado = estado;
//        this.nota = nota;
//        this.preco = preco;
//        this.precominimo = precominimo;
//        this.icms = icms;
//        this.taxaICMSP = taxaICMSP;
    }
}