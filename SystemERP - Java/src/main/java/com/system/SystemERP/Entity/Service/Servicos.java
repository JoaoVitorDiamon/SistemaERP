package com.system.SystemERP.Entity.Service;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servicos")
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idServico;
    private String refProduto;
    private String etiqueta;
    private boolean venda;
    private boolean compra;

    @OneToOne
    @JoinColumn(name = "\"idSerialNumberControl\"")
    private SerialNumberControl serialNumberControl;

    @OneToOne
    @JoinColumn(name = "\"idBarCodeType\"")
    private BarCodeType barCodeType;

    private String codigoDeBarras;
    private String descricao;
    private String notas;
    private LocalTime duracao;
    private double preco;
    private double precoMinimo;
    private int icms;
    private double taxaCMSP;

    @OneToOne
    @JoinColumn(name = "\"salesCode\"")
    private AccountingCode salesCode;

    @OneToOne
    @JoinColumn(name = "\"exportCode\"")
    private AccountingCode exportCode;

    @OneToOne
    @JoinColumn(name = "\"importCode\"")
    private AccountingCode importCode;

    @OneToOne
    @JoinColumn(name = "\"purchaseCode\"")
    private AccountingCode purchaseCode;

    @ManyToOne
    @JoinColumn(name = "\"idEnterprise\"")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "\"idAddress\"")
    private Adress address;
}
