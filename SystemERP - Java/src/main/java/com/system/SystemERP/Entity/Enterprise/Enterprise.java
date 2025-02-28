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
@Table(name = "\"Empresas\"")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idEmpresa\"")
    private Integer idEmpresa;
    @Column(name = "\"Name\"")
    private String Name;
    @Column(name = "\"NomeFantasia\"")
    private String NomeFantasia;
    @Column(name = "\"DonoId\"")
    private Integer DonoId;
    @Column(name = "\"CNPJ\"")
    private String CNPJ;
    @Column(name = "\"Email\"")
    private String Email;
    @Column(name = "\"Telefone\"")
    private String Telefone;
    @Column(name = "\"Endereco\"")
    private String Endereco;
    @Column(name = "\"CEP\"")
    private String CEP;

    @ManyToOne
    @JoinColumn(name = "idEndereco", nullable = false)
    private Adress endereco;


    @ManyToOne
    @JoinColumn(name = "idSetor", nullable = false)
    private Sector setor;

    @ManyToOne
    @JoinColumn(name = "TipoDeEmpresa_idTipoDeEmpresa")
    private EnterpriseType TipoDeEmpresaidTipoDeEmpresa;

    private LocalDateTime DataCriacao;


}