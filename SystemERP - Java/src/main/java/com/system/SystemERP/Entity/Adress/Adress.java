package com.system.SystemERP.Entity.Adress;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Endereco")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idEndereco;
    private String cep;
    private String pais;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    @OneToMany(mappedBy = "endereco")
    private List<Enterprise> empresas;


    public Adress(Integer idEndereco, String cep, String pais, String cidade, String bairro, String rua, String numero, String complemento, List<Enterprise> empresas) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.pais = pais;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.empresas = empresas;
    }
}
