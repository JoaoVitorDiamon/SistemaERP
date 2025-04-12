package com.system.SystemERP.Services.Products;

import com.system.SystemERP.Entity.Products.Product;
import com.system.SystemERP.Repository.Products.ProdutosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServices {
    private ProdutosRepository produtosRepository;

    public ProdutosServices(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

//    public Integer createProducts(ProdutosDTO produtosDTO) {
//        var product = produtosDTO.toEntity();
//        var savedProduct = produtosRepository.save(product);
//        return savedProduct.getIdProduct();
//    }


    public Product getById(Integer id) {
        return produtosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto nao encontrado!"));
    }

    public List<Product> getAll() {
        return produtosRepository.findAll();
    }

    public void delete(Integer id) {
        var exists = produtosRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Produto nao encontrado!");
        produtosRepository.deleteById(id);
    }
}
