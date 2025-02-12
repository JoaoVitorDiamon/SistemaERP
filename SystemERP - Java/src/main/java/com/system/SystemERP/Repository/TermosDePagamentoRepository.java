package com.system.SystemERP.Repository;

import com.system.SystemERP.Entity.TermosDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TermosDePagamentoRepository extends JpaRepository<TermosDePagamento, Integer> {
}