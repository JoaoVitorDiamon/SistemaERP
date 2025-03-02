package com.system.SystemERP.Entity.MiscellaneousPayments;


import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "\"MiscellaneousPayments\"")
@Data
public class MiscellaneousPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdMiscellaneousPayments\"")
    private Integer IdMiscellaneousPayments;

    @Column(name = "\"DatePayment\"")
    private Date DatePayment;

    @Column(name = "\"DateValue\"")
    private Date DateValue;

    @Column(name = "\"Label\"")
    private String Label;



    @Column(name = "\"TransferNumber\"")
    private String TransferNumber;

    @Column(name = "\"SenderName\"")
    private String SenderName;

    @Column(name = "\"BankCheck\"")
    private String BankCheck;

    @ManyToOne
    @JoinColumn(name = "\"IdTypesPayments\"", foreignKey = @ForeignKey(name = "\"FK_IdTypesPayments_MiscellaneousPayments\""))
    private TypesPayments IdTypesPayments;

    @ManyToOne
    @JoinColumn(name = "\"IdAccountBank\"", foreignKey = @ForeignKey(name = "\"FK_IdAccountBank_MiscellaneousPayments\""))
    private AccountBank IdAccountBank;


//        @Column(name = "\"Project\"")
//    private Projects Project;


    public MiscellaneousPayments(Integer idMiscellaneousPayments, Date datePayment, Date dateValue, String label, String transferNumber, String senderName, String bankCheck, TypesPayments idTypesPayments, AccountBank idAccountBank) {
        IdMiscellaneousPayments = idMiscellaneousPayments;
        DatePayment = datePayment;
        DateValue = dateValue;
        Label = label;
        TransferNumber = transferNumber;
        SenderName = senderName;
        BankCheck = bankCheck;
        IdTypesPayments = idTypesPayments;
        IdAccountBank = idAccountBank;
    }


    public MiscellaneousPayments() {
    }
}
