package com.system.SystemERP.Entity.ThirdParties;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.ClientType.ClientType;
import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"terceiros\"")
public class ThirdParties {
    public ThirdParties() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idTerceiros;
    private String nome;
    private String nomeEFantasia;

    @ManyToOne
    @JoinColumn(name = "\"ClientType\"")
    private ClientType ClientType;

    private boolean fornecedor;
    private boolean estadoAtividade;

    @ManyToOne
    @JoinColumn(name = "Adress")
    private Adress idAdress;

    private String email;
    private boolean impostoSobVenda;
    private boolean segundoImposto;


    //  private Integer tipoDeTerceiro_idTipoDeTerceiro;(fk)
    private double capital;

    @ManyToOne
    @JoinColumn(name = "\"moeda\"")
    private Coin IdCoin;
    private Integer quantidadeColaboradores;

    @Lob
    @Column(length = 10000)
    private byte[] logotipo;

    @ManyToOne
    @JoinColumn(name = "\"Enterprise\"")
    private Enterprise IdEnterprise;


    public ThirdParties(Integer idTerceiros, String nome, String nomeEFantasia, com.system.SystemERP.Entity.ClientType.ClientType clientType, boolean fornecedor, boolean estadoAtividade, Adress idAdress, String email, boolean impostoSobVenda, boolean segundoImposto, double capital, Coin idCoin, Integer quantidadeColaboradores, byte[] logotipo, Enterprise idEnterprise) {
        this.idTerceiros = idTerceiros;
        this.nome = nome;
        this.nomeEFantasia = nomeEFantasia;
        ClientType = clientType;
        this.fornecedor = fornecedor;
        this.estadoAtividade = estadoAtividade;
        this.idAdress = idAdress;
        this.email = email;
        this.impostoSobVenda = impostoSobVenda;
        this.segundoImposto = segundoImposto;
        this.capital = capital;
        IdCoin = idCoin;
        this.quantidadeColaboradores = quantidadeColaboradores;
        this.logotipo = logotipo;
        IdEnterprise = idEnterprise;
    }
}
