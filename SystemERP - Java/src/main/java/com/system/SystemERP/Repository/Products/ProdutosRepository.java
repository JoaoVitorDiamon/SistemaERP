package com.system.SystemERP.Repository.Products;

import com.system.SystemERP.Entity.Products.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
}
