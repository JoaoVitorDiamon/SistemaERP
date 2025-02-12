package com.system.SystemERP.Controller;


import com.system.SystemERP.Dtos.TermosDePagamentosDTOS;
import com.system.SystemERP.Entity.TermosDePagamento;
import com.system.SystemERP.Services.TermosDePagamentoServices;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/paymentTerms")
@RestController
public class TermosDePagamentoController {

    private TermosDePagamentoServices termosDePagamentoServices;

    public TermosDePagamentoController(TermosDePagamentoServices termosDePagamentoServices) {
        this.termosDePagamentoServices = termosDePagamentoServices;
    }

    @PostMapping
    public ResponseEntity<TermosDePagamento> createPaymentTerms(@RequestBody TermosDePagamentosDTOS termosDePagamentosDTOS) {

        var created = termosDePagamentoServices.createTermosDePagamento(termosDePagamentosDTOS);
        return ResponseEntity.created(URI.create("/paymentTerms/" + created.toString())).build();
    }

    @GetMapping("/{idPaymentTerms}")
    public ResponseEntity<TermosDePagamento> getByID(@PathVariable int idPaymentTerms) {


        return null;
    }
}
