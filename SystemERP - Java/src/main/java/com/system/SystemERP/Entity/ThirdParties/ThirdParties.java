package com.system.SystemERP.Entity.ThirdParties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "terceiros")
public class ThirdParties {
    public ThirdParties() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idTerceiros;
    private String nome;
    private String nomeEFantasia;
    //    private Integer tipoCliente_idTipoCliente;(fk)
    private boolean fornecedor;
    private boolean estadoAtividade;
    //    private Integer endereco_idEndereco;(fk)
    private String email;
    private boolean impostoSobVenda;
    private boolean segundoImposto;
    //  private Integer tipoDeTerceiro_idTipoDeTerceiro;(fk)
    private double capital;
    //  private Integer moeda_idMoeda;
    private Integer quantidadeColaboradores;
    @Lob
    @Column(length = 10000)
    private byte[] logotipo;
//  private Integer empresa_idEmpresa;(fk)


    public ThirdParties(Integer idTerceiros, String nome, String nomeEFantasia, boolean fornecedor, boolean estadoAtividade, String email, boolean impostoSobVenda, boolean segundoImposto, double capital, Integer quantidadeColaboradores, byte[] logotipo) {
        this.idTerceiros = idTerceiros;
        this.nome = nome;
        this.nomeEFantasia = nomeEFantasia;
        this.fornecedor = fornecedor;
        this.estadoAtividade = estadoAtividade;
        this.email = email;
        this.impostoSobVenda = impostoSobVenda;
        this.segundoImposto = segundoImposto;
        this.capital = capital;
        this.quantidadeColaboradores = quantidadeColaboradores;
        this.logotipo = logotipo;
    }
}
