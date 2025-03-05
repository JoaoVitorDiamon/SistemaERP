package com.system.SystemERP.Dtos.ThirdParties;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.ClientType.ClientType;
import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.ClientType.ClientTypeServices;
import com.system.SystemERP.Services.Coin.CoinServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;

@Data
public class ThirdPartiesDTO {
    private String nome;
    private String nomeEFantasia;
    private Integer idclientType;
    private boolean fornecedor;
    private boolean estadoAtividade;
    private Integer idAdress;
    private String email;
    private boolean impostoSobVenda;
    private boolean segundoImposto;
    private double capital;
    private Integer idCoin;
    private Integer quantidadeColaboradores;
    private byte[] logotipo;
    private Integer idEnterprise;

    public ThirdParty toEntity(ClientTypeServices clientTypeServices, CoinServices coinServices,
                               EnterpriseServices enterpriseServices, AddresServices addresServices) {
        return new ThirdParty(
                null,
                nome,
                nomeEFantasia,
                fetchClientyTypeByID(idclientType, clientTypeServices),
                fornecedor,
                estadoAtividade,
                fetchAdressByID(idAdress, addresServices),
                email,
                impostoSobVenda,
                segundoImposto,
                capital,
                fetchCoinByID(idCoin, coinServices),
                quantidadeColaboradores,
                logotipo,
                fetchEnterpriseByID(idEnterprise, enterpriseServices)
        );
    }

    private ClientType fetchClientyTypeByID(Integer Id, ClientTypeServices clientTypeServices) {
        var clientType = clientTypeServices.findByID(Id);
        return clientType.orElseThrow(
                () -> new EntityNotFoundException("Tipo de Cliente nao encontrado"));
    }

    private Coin fetchCoinByID(Integer Id, CoinServices coinServices) {
        var coin = coinServices.findByID(Id);
        return coin.orElseThrow(
                () -> new EntityNotFoundException("Moeda nao encontrado"));
    }

    private Enterprise fetchEnterpriseByID(Integer Id, EnterpriseServices enterpriseServices) {
        var enterprise = enterpriseServices.findByID(Id);
        return enterprise.orElseThrow(
                () -> new EntityNotFoundException("Empresa nao encontrado"));
    }

    private Adress fetchAdressByID(Integer Id, AddresServices addresServices) {
        var addres = addresServices.findByID(Id);
        return addres.orElseThrow(
                () -> new EntityNotFoundException("Endereço nao encontrado"));
    }

}
