package com.system.SystemERP.Dtos.ThirdParties;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.ClientType.ClientType;
import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import lombok.Data;

@Data
public class ThirdPartiesDTO {
    private Integer idTerceiros;
    private String nome;
    private String nomeEFantasia;
    private ClientType clientType;
    private boolean fornecedor;
    private boolean estadoAtividade;
    private Adress idAdress;
    private String email;
    private boolean impostoSobVenda;
    private boolean segundoImposto;
    private double capital;
    private Coin idCoin;
    private Integer quantidadeColaboradores;
    private byte[] logotipo;
    private Enterprise idEnterprise;

    public ThirdParty toEntity() {
        return new ThirdParty(
                idTerceiros,
                nome,
                nomeEFantasia,
                clientType,
                fornecedor,
                estadoAtividade,
                idAdress,
                email,
                impostoSobVenda,
                segundoImposto,
                capital,
                idCoin,
                quantidadeColaboradores,
                logotipo,
                idEnterprise
        );
    }
}
