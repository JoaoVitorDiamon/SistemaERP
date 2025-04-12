package com.system.SystemERP.Services.NatureProducts;


import com.system.SystemERP.Dtos.NatureProducts.NatureProductsDTO;
import com.system.SystemERP.Entity.NatureProduct.NatureProduct;
import com.system.SystemERP.Repository.NatureProduct.NatureProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureProductsServices {


    private NatureProductRepository natureProductRepository;

    public NatureProductsServices(NatureProductRepository natureProductRepository) {
        this.natureProductRepository = natureProductRepository;
    }

    public Integer createNatureProducts(NatureProductsDTO natureProductsDTO) {
        var natureProducts = natureProductsDTO.toEntity();
        var savednatureProducts = natureProductRepository.save(natureProducts);
        return savednatureProducts.getIdNatureProduct();
    }

    public NatureProduct getById(Integer id) {
        return natureProductRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Natureza do produto nao encontrada"));
    }

    public List<NatureProduct> getAll() {
        return natureProductRepository.findAll();
    }

    public void delete(Integer id) {
        var exists = natureProductRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Natureza do produto nao encontrada");
        natureProductRepository.deleteById(id);
    }
}
