package com.system.SystemERP.Repository.BarcodeType;

import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeTypeRepository extends JpaRepository<BarCodeType, Integer> {
}
