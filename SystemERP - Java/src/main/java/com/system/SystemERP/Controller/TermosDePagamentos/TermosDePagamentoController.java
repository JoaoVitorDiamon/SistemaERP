package com.system.SystemERP.Controller.TermosDePagamentos;

import com.system.SystemERP.Dtos.TermosDePagamentos.TermosDePagamentosDTOS;
import com.system.SystemERP.Entity.TermosDePagamentos.TermosDePagamento;
import com.system.SystemERP.Services.TermosDePagamentoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/paymentTerms")
@RestController
public class TermosDePagamentoController {

    private TermosDePagamentoServices termosDePagamentoServices;

    public TermosDePagamentoController(TermosDePagamentoServices termosDePagamentoServices) {
        this.termosDePagamentoServices = termosDePagamentoServices;
    }

    @PostMapping
    public ResponseEntity<String> createPaymentTerms(@RequestBody TermosDePagamentosDTOS termosDePagamentosDTOS) {
        try {
            var created = termosDePagamentoServices.createTermosDePagamento(termosDePagamentosDTOS);
            return ResponseEntity.created(URI.create("/paymentTerms/" + created.toString())).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: Dados inválidos para criar os termos de pagamento.");
        }
    }

    @GetMapping("/{idPaymentTerms}")
    public ResponseEntity<TermosDePagamento> getByID(@PathVariable Integer idPaymentTerms) {
        var terms = termosDePagamentoServices.getbyIDTermosDePagamento(idPaymentTerms);
        if (terms.isPresent()) {
            return ResponseEntity.ok(terms.get());
        }
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TermosDePagamento>> getAll() {
        var listTerms = termosDePagamentoServices.getAll();
        return ResponseEntity.ok(listTerms);
    }


    @DeleteMapping("/{idPaymentTermsDelete}")
    public ResponseEntity<Void> delete(@PathVariable("idPaymentTermsDelete") Integer id) {
        termosDePagamentoServices.delete(id);
        return ResponseEntity.noContent().build();

    }
}
