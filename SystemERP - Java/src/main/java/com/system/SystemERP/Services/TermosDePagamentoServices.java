package com.system.SystemERP.Services;


import com.system.SystemERP.Dtos.TermosDePagamentos.TermosDePagamentosDTOS;
import com.system.SystemERP.Entity.TermosDePagamentos.TermosDePagamento;
import com.system.SystemERP.Repository.TermosDePagamento.TermosDePagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<TermosDePagamento> getbyIDTermosDePagamento(Integer id) {
        return termosDePagamentoRepository.findById(id);
    }

    public List<TermosDePagamento> getAll() {
        return termosDePagamentoRepository.findAll();
    }

    public void delete(Integer id) {
        var termsExists = termosDePagamentoRepository.existsById(id);

        if (termsExists) {
            termosDePagamentoRepository.deleteById(id);
        }
    }
}
