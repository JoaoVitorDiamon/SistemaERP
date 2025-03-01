package com.system.SystemERP.Services.Products;

import com.system.SystemERP.Dtos.Products.ProdutosDTO;
import com.system.SystemERP.Entity.Products.Product;
import com.system.SystemERP.Repository.Products.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosServices {
    private ProdutosRepository produtosRepository;

    public ProdutosServices(ProdutosRepository produtosRepository){
        this.produtosRepository = produtosRepository;
    }

    public Integer createProducts(ProdutosDTO produtosDTO) {
        var product = produtosDTO.toEntity();
        var savedProduct = produtosRepository.save(product);
        return savedProduct.getIdProduct();
    }


    public Optional<Product> getById(Integer id){
        return produtosRepository.findById(id);
    }

    public List<Product> getAll(){
        return produtosRepository.findAll();
    }

    public void delete(Integer id){
        produtosRepository.deleteById(id);
    }
}
