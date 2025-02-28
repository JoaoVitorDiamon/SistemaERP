package com.system.SystemERP.Entity.Members;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.Position.Position;
import com.system.SystemERP.Entity.User.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"Membros\"")
@Data
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idMembro;

    @ManyToOne
    @JoinColumn(name = "Empresas_idEmpresa")
    private Enterprise EmpresaidEmpresa;

    @ManyToOne
    @JoinColumn(name = "Usuarios_Id")
    private User UsuarioId;

    @ManyToOne
    @JoinColumn(name = "\"Cargos_idCargo\"")
    private Position CargoidCargo;

    private String NaturezaMembro;

    private String Genero;

    private String Telefone;

    private String CEP;

    private String DataNascimento;

    private String AssociacaoPublica;
}
