package com.system.SystemERP.Entity.InternalTransfer;


import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "\"InternalTransfer\"")
@Data
public class InternalTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDInternalTransfer\"")
    private Integer IDInternalTransfer;

    @ManyToOne
    @JoinColumn(name = "\"IdPayingAccount\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountPayment_InternalTransfer\""))
    private AccountBank IdPayingAccount;

    @ManyToOne
    @JoinColumn(name = "\"IdReceiverAccount\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountReceiver_InternalTransfer\""))
    private AccountBank IdReceiverAccount;

    @ManyToOne
    @JoinColumn(name = "\"IdPaymentTypes\"", foreignKey = @ForeignKey(name = "\"FK_IdPaymentsTypes_InternalTransfer\""))
    private TypesPayments IdPaymentTypes;

    @Column(name = "\"PaymentDate\"")
    private Date PaymentDate;

    @Column(name = "\"Description\"")
    private String Description;

    public InternalTransfer() {
    }

    public InternalTransfer(Integer IDInternalTransfer, AccountBank idPayingAccount, AccountBank idReceiverAccount, TypesPayments idPaymentTypes, Date paymentDate, String description, Double value) {
        this.IDInternalTransfer = IDInternalTransfer;
        IdPayingAccount = idPayingAccount;
        IdReceiverAccount = idReceiverAccount;
        IdPaymentTypes = idPaymentTypes;
        PaymentDate = paymentDate;
        Description = description;
        Value = value;
    }

    @Column(name = "\"Value\"")
    private Double Value;
}
