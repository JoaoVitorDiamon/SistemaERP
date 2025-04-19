package com.system.SystemERP.Entity.ExpenseReport;


import com.system.SystemERP.Entity.Members.Members;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "\"ExpenseReport\"")
public class ExpenseReport {


    @Id
    @Column(name = "\"IdExpenseReport\"")
    private Integer idExpenseReport;


    @Column(name = "\"InicialDate\"")
    private Date inicialDate;

    @Column(name = "\"EndDate\"")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "\"IdMembers\"", foreignKey = @ForeignKey(name = "\"FK_IdMembers_ExpenseReport\""))
    private Members idMembers;

    @ManyToOne
    @JoinColumn(name = "\"IdResponsible\"", foreignKey = @ForeignKey(name = "\"FK_IdResponsible_ExpenseReport\""))
    private Members idResponsible;

    @Column(name = "\"Note\"")
    private String note;

    public ExpenseReport() {
    }

    public ExpenseReport(Integer idExpenseReport, Date inicialDate, Date endDate, Members idMembers, Members idResponsible, String note) {
        this.idExpenseReport = idExpenseReport;
        this.inicialDate = inicialDate;
        this.endDate = endDate;
        this.idMembers = idMembers;
        this.idResponsible = idResponsible;
        this.note = note;
    }
}
