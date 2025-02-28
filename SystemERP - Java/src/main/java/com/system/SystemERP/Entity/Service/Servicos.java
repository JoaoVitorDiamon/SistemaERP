package com.system.SystemERP.Entity.Service;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

    @Entity
    @Data
    @Table(name = "\"servicos\"")
    public class Servicos{

        public Servicos(){}

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer idServico;
        private String refProduto;
        private String etiqueta;
        private boolean venda;
        private boolean compra;
        //private Integer controleNumeroDeSerie_IdControleNumeroDeSerie (FK)
        //private Integer tipoCodigoDeBarras_IdTipoCodigoDeBarras (FK)
        private String codigoDeBarras;
        private String descricao;
        private String notas;
        private LocalTime duracao; //verificar localtime depois, nao sei se está certo
        private double preco;
        private double precoMinimo;
        private int icms;
        private double taxaCMSP;
        //private Integer codVendas_IdCodigosContabeis (FK)
        //private Integer codExportacao_IdCodigosContabeis (FK)
        //private Integer codImportacao_IdCodigosContabeis (FK)
        //private Integer codCompra_IdCodigosContabeis (FK)
        //private Integer empresa_IdEmpresa (FK)
        //private Integer endereco_idEndereco;(fk)


        public Servicos(Integer idServico, String refProduto, String etiqueta, boolean venda, boolean compra, String codigoDeBarras, String descricao, String notas, LocalTime duracao, double preco, double precoMinimo, int icms, double taxaCMSP) {
            this.idServico = idServico;
            this.refProduto = refProduto;
            this.etiqueta = etiqueta;
            this.venda = venda;
            this.compra = compra;
            this.codigoDeBarras = codigoDeBarras;
            this.descricao = descricao;
            this.notas = notas;
            this.duracao = duracao;
            this.preco = preco;
            this.precoMinimo = precoMinimo;
            this.icms = icms;
            this.taxaCMSP = taxaCMSP;
        }
    }
