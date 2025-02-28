package com.system.SystemERP.Controller.PaymentTerms;

import com.system.SystemERP.Dtos.PaymentTerms.PaymentTermsDTOS;
import com.system.SystemERP.Entity.PaymentTerms.PaymentTerms;
import com.system.SystemERP.Services.PaymentTerms.PaymentTermsServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RequestMapping("/paymentTerms")
@RestController
@Tag(name = "Termos de Pagamentos")
public class PaymentTermsController {

    private final PaymentTermsServices paymentTermsServices;

    public PaymentTermsController(PaymentTermsServices paymentTermsServices) {
        this.paymentTermsServices = paymentTermsServices;
    }

    @PostMapping
    @Operation(summary = "Cria um Termo", description = "Cria um Termo")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Termo de Pagamento criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Termo de pagamento invalido")
    })

    public ResponseEntity<String> createPaymentTerms(@Parameter(description = "Nome de Termos Valido")
                                                     @RequestBody PaymentTermsDTOS paymentTermsDTOS) {
        try {
            var created = paymentTermsServices.createPaymentTerms(paymentTermsDTOS);
            return ResponseEntity.created(URI.create("/paymentTerms/" + created.toString())).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: Dados inválidos para criar os termos de pagamento.");
        }
    }

    @Operation(summary = "Buscar Termo por ID", description = "Retorna os detalhes de um Termos específico pelo ID.")
    @GetMapping("/{idPaymentTerms}")

    public ResponseEntity<PaymentTerms> getByID(@PathVariable Integer idPaymentTerms) {
        var terms = paymentTermsServices.findByIDPaymentTerms(idPaymentTerms);
        return terms.isPresent() ? ResponseEntity.ok(terms.get()) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Busca todos os Termos por ID", description = "Retorna os detalhes de todos os Termos")
    @GetMapping

    public ResponseEntity<List<PaymentTerms>> getAll() {
        var listTerms = paymentTermsServices.getAll();
        return ResponseEntity.ok(listTerms);
    }


    @Operation(summary = "Apaga um Termo de acordo com o ID", description = "Apaga um Termo de acordo com o ID ")
    @DeleteMapping("/{idPaymentTerms}")

    public ResponseEntity<Void> delete(@Parameter(description = "ID do Termo") @PathVariable Integer idPaymentTerms) {
        paymentTermsServices.delete(idPaymentTerms);
        return ResponseEntity.noContent().build();

    }
}
