package com.system.SystemERP.Repository.MaterialType;

import com.system.SystemERP.Entity.MaterialType.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialType, Integer> {
}
