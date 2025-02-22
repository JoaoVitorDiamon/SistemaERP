package com.system.SystemERP.Repository.Products;

import com.system.SystemERP.Entity.Products.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
}
