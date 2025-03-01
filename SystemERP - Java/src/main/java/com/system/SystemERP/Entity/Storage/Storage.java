package com.system.SystemERP.Entity.Storage;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"Storages\"")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdStorage\"")
    private Integer StorageId;

    @Column(name = "\"Name\"")
    private String Name;

    @Column(name = "\"Description\"")
    private String Description;

    @Column(name = "\"Phone\"")
    private String Phone;

    @ManyToOne
    @JoinColumn(name = "\"IdAddress\"" , foreignKey = @ForeignKey(name = "\"FK_IdAddress_Storage\""))
    private Adress Address;

    @ManyToOne
    @JoinColumn(name = "\"IdEnterprise\"", foreignKey = @ForeignKey(name = "\"FK_IdEnterprise_Storage\""))
    private Enterprise Enterprise;

    public Storage(Integer StorageId, String Name, String Description, String Phone, Adress Address, Enterprise Enterprise) {
        this.StorageId = StorageId;
        this.Name = Name;
        this.Description = Description;
        this.Phone = Phone;
        this.Address = Address;
        this.Enterprise = Enterprise;
    }

    public Storage() {

    }
}
