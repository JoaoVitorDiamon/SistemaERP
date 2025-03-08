package com.system.SystemERP.Repository.ProductionOrder;

import com.system.SystemERP.Entity.ProductionOrder.ProductionOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductionOrderRepositorty  extends JpaRepository<ProductionOrder, Integer> {
}
