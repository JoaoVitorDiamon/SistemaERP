package com.system.SystemERP.Dtos.Service;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import com.system.SystemERP.Entity.Service.Servicos;
import lombok.Data;
import java.time.LocalTime;

@Data
public class ServiceDTO {
    private Integer idServico;
    private String refProduto;
    private String etiqueta;
    private boolean venda;
    private boolean compra;
    private SerialNumberControl idSerialNuberControl;
    private BarCodeType idBarCodeType;
    private String codigoDeBarras;
    private String descricao;
    private String notas;
    private LocalTime duracao;
    private double preco;
    private double precoMinimo;
    private int icms;
    private double taxaCMSP;
    private AccountingCode salesCode;
    private AccountingCode exportCode;
    private AccountingCode importCode;
    private AccountingCode purchaseCode;
    private Enterprise idEnterprise;
    private Adress idAdress;

    public Servicos toEntity() {
        return new Servicos(
                idServico,
                refProduto,
                etiqueta,
                venda,
                compra,
                idSerialNuberControl,
                idBarCodeType,
                codigoDeBarras,
                descricao,
                notas,
                duracao,
                preco,
                precoMinimo,
                icms,
                taxaCMSP,
                salesCode,
                exportCode,
                importCode,
                purchaseCode,
                idEnterprise,
                idAdress
        );
    }
}
