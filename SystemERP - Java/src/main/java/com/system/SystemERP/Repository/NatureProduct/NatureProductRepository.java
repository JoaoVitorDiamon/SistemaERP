package com.system.SystemERP.Repository.NatureProduct;

import com.system.SystemERP.Entity.NatureProduct.NatureProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NatureProductRepository extends JpaRepository<NatureProduct, Integer> {
}
