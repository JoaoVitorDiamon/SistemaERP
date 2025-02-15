package com.system.SystemERP.Entity.TermosDePagamentos;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@Entity
@Table(name = "termos_de_pagamento")
public class TermosDePagamento {
    @Id
    @Column(name = "idTermosDePagamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idTermosDePagamento;

    @Column(name = "nomeTermosDePagamentos")
    private String nomeTermosDePagamentos;

    @CreationTimestamp
    @Column(name = "dataCriacao")
    private Instant dataCriacao;


    public Integer getIdTermosDePagamento() {
        return idTermosDePagamento;
    }

    public void setIdTermosDePagamento(Integer idTermosDePagamento) {
        this.idTermosDePagamento = idTermosDePagamento;
    }

    public String getNomeTermosDePagamentos() {
        return nomeTermosDePagamentos;
    }

    public void setNomeTermosDePagamentos(String nomeTermosDePagamentos) {
        this.nomeTermosDePagamentos = nomeTermosDePagamentos;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public TermosDePagamento() {
    }

    public TermosDePagamento(Integer idTermosDePagamento, String nomeTermosDePagamentos, Instant dataCriacao, Instant dataAtualizacao) {
        this.idTermosDePagamento = idTermosDePagamento;
        this.nomeTermosDePagamentos = nomeTermosDePagamentos;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    @UpdateTimestamp
    @Column(name = "dataAtualizacao")
    private Instant dataAtualizacao;
}
