package com.system.SystemERP.Entity.Salary;


import com.system.SystemERP.Entity.AccountBank.AccountBank;
import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Table(name = "\"Salary\"")
@Entity
@Data
@NoArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdSalary\"")
    private Integer IdSalary;

    @ManyToOne
    @JoinColumn(name = "\"IdMembers\"",foreignKey = @ForeignKey(name = "\"FK_IdMembers_Salary\""))
    private Members members;

    @Column(name = "\"Label\"")
    private String Label;
    @Column(name = "\"DateStart\"")
    private Date DateStart;
    @Column(name = "\"EndDate\"")
    private Date EndDate;
    @Column(name = "\"Value\"")
    private Double Value;

    @ManyToOne
    @JoinColumn(name = "\"IdAccountBank\"",foreignKey = @ForeignKey(name = "\"FK_IdAccountBank_Salary\""))
    private AccountBank AccountBank;

    @ManyToOne
    @JoinColumn(name = "\"IdTypePayment\"", nullable = false, foreignKey = @ForeignKey(name = "\"FK_IdTypePayment_Salary\""))
    private TypesPayments TypePayment;

    @Column(name = "\"PaymentDate\"")

    private Instant PaymentDate;

    @Column(name = "\"TransferNumber\"")
    private String TransferNumber;

    public Salary(Integer idSalary, Members members, String label, Date dateStart, Date endDate, Double value, com.system.SystemERP.Entity.AccountBank.AccountBank accountBank, TypesPayments typePayment, Instant paymentDate, String transferNumber) {
        IdSalary = idSalary;
        this.members = members;
        Label = label;
        DateStart = dateStart;
        EndDate = endDate;
        Value = value;
        AccountBank = accountBank;
        TypePayment = typePayment;
        PaymentDate = paymentDate;
        TransferNumber = transferNumber;
    }
}
