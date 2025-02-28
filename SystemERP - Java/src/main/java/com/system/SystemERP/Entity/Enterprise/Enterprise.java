package com.system.SystemERP.Entity.Enterprise;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.EnterpriseType.EnterpriseType;
import com.system.SystemERP.Entity.Sector.Sector;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idEmpresa;
    private String name;
    private String nomeFantasia;


//    private Integer donoId;(fk)


    private String cnpj;
    private String email;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "idEndereco", nullable = false)
    private Adress endereco;

    @ManyToOne
    @JoinColumn(name = "TipoDeEmpresa", referencedColumnName = "idTipoDeEmpresa", nullable = false)
    private EnterpriseType tipoDeEmpresa;

    @ManyToOne
    @JoinColumn(name = "idSetor", nullable = false)
    private Sector setor;

    private LocalDateTime dataCriacao;

    public Enterprise(Integer idEmpresa, String name, String nomeFantasia, String cnpj, String email, String telefone, Adress endereco, EnterpriseType tipoDeEmpresa, Sector setor, LocalDateTime dataCriacao) {
        this.idEmpresa = idEmpresa;
        this.name = name;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipoDeEmpresa = tipoDeEmpresa;
        this.setor = setor;
        this.dataCriacao = dataCriacao;
    }
}