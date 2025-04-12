package com.system.SystemERP.Controller.InvoiceTypes;

import com.system.SystemERP.Dtos.InvoiceTypes.InvoiceTypesDTO;
import com.system.SystemERP.Entity.InvoiceTypes.InvoiceTypes;
import com.system.SystemERP.Services.InvoiceTypes.InvoiceTypesServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Tipos de Faturas")
@RequestMapping("/invoiceTypes")
public class InvoiceTypesController {
    private final InvoiceTypesServices invoiceTypesServices;

    public InvoiceTypesController(InvoiceTypesServices invoiceTypesServices) {
        this.invoiceTypesServices = invoiceTypesServices;
    }

    @PostMapping
    @Operation(description = "Criar Fatura", summary = "Criar Fatura")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Tipos de Fatura criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Tipos de Fatura invalido")
    })
    public ResponseEntity<String> createInvoice(@RequestBody InvoiceTypesDTO invoiceTypesDTO) {
        try {
            var invoiceTypes = invoiceTypesServices.createInvoice(invoiceTypesDTO);
            return ResponseEntity.created(URI.create("/InvoiceTypes/" + invoiceTypes.toString())).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: Dados inválidos para criar os termos de pagamento.");
        }
    }

    @GetMapping("/{idInvoiceTypes}")
    @Operation(summary = "Retornar Tipo atraves do ID", description = "Retornar todos os dados do Tipo De Fatura atraves do ID")
    public ResponseEntity<InvoiceTypes> findByID(@PathVariable Integer idInvoiceTypes) {
        var invoiceTypesExists = invoiceTypesServices.getByID(idInvoiceTypes);
        return ResponseEntity.ok(invoiceTypesExists);

    }


    @GetMapping
    @Operation(summary = "Retornar todos os Tipos atraves do ID", description = "Retornar todos os Tipo De Fatura")
    public ResponseEntity<List<InvoiceTypes>> getAll() {
        var listTypes = invoiceTypesServices.getAll();
        return ResponseEntity.ok(listTypes);
    }

    @DeleteMapping("{idInvoiceTypes}")
    @Operation(summary = "Deletar tipo de fatura atraves do ID", description = "Deletar tipo de fatura atraves do ID")
    public ResponseEntity<Void> delete(@PathVariable Integer idInvoiceTypes) {
        invoiceTypesServices.deleteByID(idInvoiceTypes);
        return ResponseEntity.noContent().build();
    }
}



