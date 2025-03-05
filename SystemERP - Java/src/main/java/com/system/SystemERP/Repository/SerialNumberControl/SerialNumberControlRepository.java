package com.system.SystemERP.Repository.SerialNumberControl;

import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerialNumberControlRepository extends JpaRepository<SerialNumberControl, Integer>{
}
