package com.system.SystemERP.Repository.Enterprise;

import com.system.SystemERP.Entity.Enterprise.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
}
