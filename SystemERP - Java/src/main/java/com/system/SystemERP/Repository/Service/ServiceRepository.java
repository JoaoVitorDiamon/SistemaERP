package com.system.SystemERP.Repository.Service;

import com.system.SystemERP.Entity.Service.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Servicos, Integer> {
}
