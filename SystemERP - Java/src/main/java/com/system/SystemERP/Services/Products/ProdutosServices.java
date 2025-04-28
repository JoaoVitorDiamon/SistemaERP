package com.system.SystemERP.Services.Products;

import com.system.SystemERP.Dtos.Products.ProdutosDTO;
import com.system.SystemERP.Entity.Products.Product;
import com.system.SystemERP.Repository.Products.ProdutosRepository;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import com.system.SystemERP.Services.BarCodeType.BarCodeTypeServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import com.system.SystemERP.Services.NatureProducts.NatureProductsServices;
import com.system.SystemERP.Services.SerialNumberControl.SerialNumberControlService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServices {
    private ProdutosRepository produtosRepository;
    private SerialNumberControlService serialNumberControlService;
    private BarCodeTypeServices barCodeTypeServices;
    private NatureProductsServices natureProductsServices;
    private AccountingCodeServices accountingCodeServices;
    private EnterpriseServices enterpriseServices;


    public ProdutosServices(ProdutosRepository produtosRepository, SerialNumberControlService serialNumberControlService, BarCodeTypeServices barCodeTypeServices, NatureProductsServices natureProductsServices, AccountingCodeServices accountingCodeServices, EnterpriseServices enterpriseServices) {
        this.produtosRepository = produtosRepository;
        this.serialNumberControlService = serialNumberControlService;
        this.barCodeTypeServices = barCodeTypeServices;
        this.natureProductsServices = natureProductsServices;
        this.accountingCodeServices = accountingCodeServices;
        this.enterpriseServices = enterpriseServices;
    }

    public Integer createProducts(ProdutosDTO produtosDTO) {
        var product = produtosDTO.toEntity(serialNumberControlService,barCodeTypeServices,natureProductsServices,accountingCodeServices,enterpriseServices);
        var savedProduct = produtosRepository.save(product);
        return savedProduct.getIdProduct();
    }


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


    public void updateProduct(Integer id, ProdutosDTO produtosDTO){
        var exists = produtosRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Produto nao encontrado!");
        var product = produtosDTO.toEntity(serialNumberControlService,barCodeTypeServices,natureProductsServices,accountingCodeServices,enterpriseServices);
        product.setIdProduct(id);
        produtosRepository.save(product);
    }
}
