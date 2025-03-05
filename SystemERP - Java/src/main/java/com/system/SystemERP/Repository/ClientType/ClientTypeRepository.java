package com.system.SystemERP.Repository.ClientType;

import com.system.SystemERP.Entity.ClientType.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTypeRepository extends JpaRepository<ClientType, Integer> {
}
