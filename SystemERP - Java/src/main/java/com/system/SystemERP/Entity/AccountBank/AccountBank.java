package com.system.SystemERP.Entity.AccountBank;
import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Entity.TypeAccount.TypeAccount;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "\"ContasFinanceiras\"")
public class AccountBank {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idContaFinanceira")
        private Integer id;

        private String rotuloBanco;

        private String contasFinanceiras;

        @ManyToOne
        @JoinColumn(name = "tipo_conta_id")
        private TypeAccount tipoDeConta;

        @ManyToOne
        @JoinColumn(name = "coin_id")
        private Coin moeda;

        private Boolean estadoAtividade;

        private String pais;

        private String estado;

        private String endereco;

        private String comentario;

        private Double saldoInicial;

        private Date data;

        private BigDecimal saldoMinimo;

        private BigDecimal saldoMinimoDesejado;

        private String numeroConta;

        private String titular;

        private String enderecoTitular;

        private String cep;

        @ManyToOne
        @JoinColumn(name = "codigo_contabil_id")
        private AccountingCode codigoContabil;

}
