package com.system.SystemERP.Dtos.Storage;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.Storage.Storage;
import lombok.Data;

@Data
public class StorageDTO {
    private Integer idArmazem;
    private String nome;
    private String descricao;
    private String telefone;
    private Adress endereco;
    private Enterprise empresa;

    public Storage toEntity() {
        return new Storage(
                idArmazem,
                nome,
                descricao,
                telefone,
                endereco,
                empresa
        );
    }
}
