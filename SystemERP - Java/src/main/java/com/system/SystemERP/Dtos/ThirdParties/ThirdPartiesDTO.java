package com.system.SystemERP.Dtos.ThirdParties;

import lombok.Data;

@Data
public class ThirdPartiesDTO {
    private Integer idTerceiros;
    private String nome;
    private String nomeEFantasia;
    private boolean fornecedor;
    private boolean estadoAtividade;
    private String email;
    private boolean impostoSobVenda;
    private boolean segundoImposto;
    private double capital;
    private Integer quantidadeColaboradores;
    private byte[] logotipo;
}
