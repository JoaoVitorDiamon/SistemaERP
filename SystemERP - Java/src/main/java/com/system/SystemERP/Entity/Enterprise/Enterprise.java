package com.system.SystemERP.Entity.Enterprise;

import com.system.SystemERP.Entity.EnterpriseType.EnterpriseType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Empresas")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;
    private String name;
    private String nomeFantasia;
    private Integer donoId;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "TipoDeEmpresaidTipoDeEmpresa", referencedColumnName = "idTipoDeEmpresa")
    private EnterpriseType tipoDeEmpresa;

//    @ManyToOne
//    @JoinColumn(name = "SetoridSetor", referencedColumnName = "idSetor")
//    private Setor setor;

    private LocalDateTime dataCriacao;

    public Enterprise(Integer idEmpresa, String name, String nomeFantasia, Integer donoId, String cnpj, String email, String telefone, String endereco, String cep, EnterpriseType tipoDeEmpresa, LocalDateTime dataCriacao) {
        this.idEmpresa = idEmpresa;
        this.name = name;
        this.nomeFantasia = nomeFantasia;
        this.donoId = donoId;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.tipoDeEmpresa = tipoDeEmpresa;
        this.dataCriacao = dataCriacao;
    }
}