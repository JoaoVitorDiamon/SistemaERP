package com.system.SystemERP.Controller.TypesPayments;

import com.system.SystemERP.Dtos.TypesPayments.TypesPaymentsDTO;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Tipos de Pagamentos")
@RequestMapping("/typesPayments")
public class TypesPaymentsController {
    private TypesPaymentsServices typesPaymentsServices;

    public TypesPaymentsController(TypesPaymentsServices typesPaymentsServices) {
        this.typesPaymentsServices = typesPaymentsServices;
    }


    @PostMapping
    @Operation(summary = "Criar um Tipo de Pagamento")
    public ResponseEntity<TypesPayments> createTypesPayments(@RequestBody TypesPaymentsDTO typesPaymentsDTO) {
        var savedID = typesPaymentsServices.createTypePayment(typesPaymentsDTO);
        return ResponseEntity.created(URI.create("typesPayments" + savedID.toString())).build();
    }

    @GetMapping("/{idTypesPayments}")
    @Operation(summary = "Busca um Tipo de Pagamento atraves do ID")
    public ResponseEntity<TypesPayments> findByID(@PathVariable Integer idTypesPayments) {
        var typesPaymentsExists = typesPaymentsServices.findByID(idTypesPayments);
        return ResponseEntity.ok(typesPaymentsExists);
    }

    @GetMapping
    @Operation(summary = "Busca Todos os  Tipos de Pagamentos")
    public ResponseEntity<List<TypesPayments>> findAll() {
        var listTypesPayments = typesPaymentsServices.findAll();
        return ResponseEntity.ok(listTypesPayments);
    }

    @DeleteMapping("{idTypesPayments}")
    @Operation(summary = "Apaga o Tipo de Pagamento atraves do ID")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idTypesPayments) {
        typesPaymentsServices.deleteByID(idTypesPayments);
        return ResponseEntity.noContent().build();
    }


}
