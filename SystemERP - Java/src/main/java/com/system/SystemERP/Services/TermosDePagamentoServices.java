package com.system.SystemERP.Services;


import com.system.SystemERP.Dtos.TermosDePagamentosDTOS;
import com.system.SystemERP.Entity.TermosDePagamento;
import com.system.SystemERP.Repository.TermosDePagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class TermosDePagamentoServices {
    private TermosDePagamentoRepository termosDePagamentoRepository;

    public TermosDePagamentoServices(TermosDePagamentoRepository termosDePagamentoRepository) {
        this.termosDePagamentoRepository = termosDePagamentoRepository;
    }

    public Integer createTermosDePagamento(TermosDePagamentosDTOS termosDePagamentosDTOS) {

        var paymentTerms = new TermosDePagamento(
                null,
                termosDePagamentosDTOS.nome(),
                null,
                null);

        var savedTerms = termosDePagamentoRepository.save(paymentTerms);

        return savedTerms.getIdTermosDePagamento();
    }


}
