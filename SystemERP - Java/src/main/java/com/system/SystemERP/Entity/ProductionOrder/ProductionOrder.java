package com.system.SystemERP.Entity.ProductionOrder;

import com.system.SystemERP.Entity.MaterialType.MaterialType;
import com.system.SystemERP.Entity.Products.Product;
import com.system.SystemERP.Entity.Storage.Storage;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "\"ProductionOrder\"")
public class ProductionOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdProductionOrder\"")
    private Integer IdProductionOrder;

    @ManyToOne
    @JoinColumn(name = "\"IdMaterialType\"", nullable = false, foreignKey = @ForeignKey(name = "\"FK_IdMaterialType_ProductionOrder\""))
    private MaterialType MaterialType;

    @ManyToOne
    @JoinColumn(name = "\"IdProduct\"", nullable = false, foreignKey = @ForeignKey(name = "\"FK_IdProduct_ProductionOrder\""))
    private Product IdProduct;

    @Column(nullable = false, name = "\"Quantity\"")
    private Integer Quantity;

    @Column(nullable = false, name = "\"Label\"")
    private String Label;

    @ManyToOne
    @JoinColumn(name = "\"IdStorage\"", nullable = false, foreignKey = @ForeignKey(name = "\"FK_IdStorage_ProductionOrder\""))
    private Storage IdStorage;

    @Column(name = "\"StartDate\"", nullable = false)
    private LocalDate StartDate;

    @Column(name = "\"EndDate\"")
    private LocalDate EndDate;


    @ManyToOne
    @JoinColumn(name = "\"IdThirdParty\"", foreignKey = @ForeignKey(name = "\"FK_IdThirdParty_ProductionOrder\""))
    private ThirdParty IdThirdParty;

    public ProductionOrder() {
    }

    public ProductionOrder(Integer idProductionOrder, com.system.SystemERP.Entity.MaterialType.MaterialType materialType, Product idProduct, Integer quantity, String label, Storage idStorage, LocalDate startDate, LocalDate endDate, ThirdParty idThirdParty) {
        IdProductionOrder = idProductionOrder;
        MaterialType = materialType;
        IdProduct = idProduct;
        Quantity = quantity;
        Label = label;
        IdStorage = idStorage;
        StartDate = startDate;
        EndDate = endDate;
        IdThirdParty = idThirdParty;
    }

}
