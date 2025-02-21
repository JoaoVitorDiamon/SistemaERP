package com.system.SystemERP.Services.Products;

import com.system.SystemERP.Dtos.Products.ProdutosDTO;
import com.system.SystemERP.Entity.Products.Produto;
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

    public Integer CreateProducts(ProdutosDTO produtosDTO){
        var products = new Produto(null, produtosDTO.nome());
        var savedProduct = produtosRepository.save(products);
        return savedProduct.getIdProduto();
    }

    public Optional<Produto> getById(Integer id){
        return produtosRepository.findById(id);
    }

    public List<Produto> getAll(){
        return produtosRepository.findAll();
    }

    public void delete(Integer id){
        produtosRepository.deleteById(id);
    }
}
