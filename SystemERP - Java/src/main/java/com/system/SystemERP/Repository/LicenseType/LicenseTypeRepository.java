package com.system.SystemERP.Repository.LicenseType;

import com.system.SystemERP.Entity.LicenseType.LicenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseTypeRepository extends JpaRepository<LicenseType, Integer> {
}
