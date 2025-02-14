package com.system.SystemERP.Repository.TermosDePagamento;

import com.system.SystemERP.Entity.TermosDePagamentos.TermosDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TermosDePagamentoRepository extends JpaRepository<TermosDePagamento, Integer> {
}