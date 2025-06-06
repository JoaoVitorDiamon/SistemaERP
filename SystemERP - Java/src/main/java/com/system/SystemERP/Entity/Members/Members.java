package com.system.SystemERP.Entity.Members;

import com.system.SystemERP.Entity.CollectiveLicense.CollectiveLicense;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.Position.Position;
import com.system.SystemERP.Entity.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "\"Members\"")
@Data
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "\"IdMembers\"")
    private Integer IdMembers;

    @ManyToOne
    @JoinColumn(name = "IdEnterprise", foreignKey = @ForeignKey(name = "\"FK_IdEnterprise_Members\""))
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "IdUser", foreignKey = @ForeignKey(name = "\"FK_IdUser_Members\""))
    private User User;

    @ManyToOne
    @JoinColumn(name = "\"IdPosition\"", foreignKey = @ForeignKey(name = "\"FK_IdPosition_Members\""))
    private Position Position;

    @Column(name = "\"NatureMember\"")
    private String NatureMember;

    @Column(name = "\"Gender\"")
    private String Gender;

    @Column(name = "\"Telephone\"")
    private String Telephone;

    @Column(name = "\"ZipCode\"")
    private String ZipCode;

    @Column(name = "\"DateOfBirth\"")
    private String DateOfBirth;

    @Column(name = "\"PublicAssociation\"")
    private String PublicAssociation;

    @ManyToMany(mappedBy = "members")
    private List<CollectiveLicense> collectiveLicenses;
}
