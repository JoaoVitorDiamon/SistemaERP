package com.system.SystemERP.Entity.JobVacancy;


import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Entity.Position.Position;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "\"JobVacancy\"")
public class JobVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdJobVacancy\"")
    private Integer IdJobVacancy;

    @ManyToOne
    @JoinColumn(name = "\"IdPosition\"", foreignKey = @ForeignKey(name = "\"FK_IdPosition_JobVacancy\""))
    private Position IdPosition;

    @ManyToOne
    @JoinColumn(name = "\"IdResponsible\"", foreignKey = @ForeignKey(name = "\"FK_IdResponsible_JobVacancy\""))
    private Members IdResponsible;

    @ManyToOne
    @JoinColumn(name = "\"IdSupervisor\"", foreignKey = @ForeignKey(name = "\"FK_IdSupervisor_JobVacancy\""))
    private Members IdSupervisor;

    @ManyToOne
    @JoinColumn(name = "\"IdAdress\"", foreignKey = @ForeignKey(name = "\"FK_IdAdress_JobVacancy\""))
    private Adress IdAdress;

    @Column(name = "\"ExpectedDate\"")
    private Date ExpectedDate;

    @Column(name = "\"Salary\"")
    private Double Salary;

    @Column(name = "\"Description\"")
    private String Description;


    public JobVacancy() {
    }

    public JobVacancy(Integer idJobVacancy, Position idPosition, Members idResponsible, Members idSupervisor, Adress idAdress, Date expectedDate, Double salary, String description) {
        IdJobVacancy = idJobVacancy;
        IdPosition = idPosition;
        IdResponsible = idResponsible;
        IdSupervisor = idSupervisor;
        IdAdress = idAdress;
        ExpectedDate = expectedDate;
        Salary = salary;
        Description = description;
    }
}
