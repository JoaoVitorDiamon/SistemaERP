package com.system.SystemERP.Controller.NatureProducts;

import com.system.SystemERP.Dtos.NatureProducts.NatureProductsDTO;
import com.system.SystemERP.Entity.NatureProduct.NatureProduct;
import com.system.SystemERP.Services.NatureProducts.NatureProductsServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/naturezaProduto")
@Tag(name = "NatureProducts")
@Controller
public class NatureProductsController {

    private NatureProductsServices natureProductsServices;

    public NatureProductsController(NatureProductsServices natureProductsServices) {
        this.natureProductsServices = natureProductsServices;
    }

    @PostMapping
    @Operation(summary = "Cria uma Natureza para o Produto", description = "Cria uma Natureza de Produto")
    public ResponseEntity<NatureProduct> createNatureProduct(@RequestBody NatureProductsDTO natureProductsDTO){
        var created = natureProductsServices.createNatureProducts(natureProductsDTO);
        return ResponseEntity.created(URI.create("/naturezaProduto/" + created.toString())).build();
    }

    @GetMapping("/{idNatureProduct}")
    @Operation(summary = "Busca uma Natureza para o Produto", description = "Busca uma Natureza de Produto")
    public ResponseEntity<NatureProduct> findById(@PathVariable Integer idNatureProduct){
        var exist = natureProductsServices.getById(idNatureProduct);
        return ResponseEntity.ok(exist);
    }

    @GetMapping
    @Operation(summary = "Busca todas as Natureza dos Produto", description = "Busca todas as Natureza dos Produtos")
    public ResponseEntity<List<NatureProduct>> findAll(){
        var listNatureProduct = natureProductsServices.getAll();
        return ResponseEntity.ok(listNatureProduct);
    }

    @DeleteMapping("/{idNatureProduct}")
    @Operation(summary = "Deleta uma Natureza para o Produto", description = "Deleta uma Natureza de Produto")
    public ResponseEntity<Void> delete(@PathVariable Integer idNatureProduct){
        natureProductsServices.delete(idNatureProduct);
        return ResponseEntity.noContent().build();
    }
}
