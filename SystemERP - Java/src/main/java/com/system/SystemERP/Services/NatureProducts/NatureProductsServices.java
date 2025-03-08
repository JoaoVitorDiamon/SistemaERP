package com.system.SystemERP.Services.NatureProducts;


import com.system.SystemERP.Dtos.NatureProducts.NatureProductsDTO;
import com.system.SystemERP.Entity.NatureProduct.NatureProduct;
import com.system.SystemERP.Repository.NatureProduct.NatureProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NatureProductsServices {

    @Autowired
    private NatureProductRepository natureProductRepository;

    public NatureProductsServices(NatureProductRepository natureProductRepository) {
        this.natureProductRepository = natureProductRepository;
    }

    public Integer createNatureProducts(NatureProductsDTO natureProductsDTO) {
        var natureProducts = natureProductsDTO.toEntity();
        var savednatureProducts = natureProductRepository.save(natureProducts);
        return savednatureProducts.getIdNatureProduct();
    }

    public Optional<NatureProduct> getById(Integer id){
        return natureProductRepository.findById(id);
    }

    public List<NatureProduct> getAll(){
        return natureProductRepository.findAll();
    }

    public void delete(Integer id){
        natureProductRepository.deleteById(id);
    }
}
