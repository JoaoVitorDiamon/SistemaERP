package com.system.SystemERP.Repository.InternalTransfer;

import com.system.SystemERP.Entity.InternalTransfer.InternalTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InternalTransferRepository extends JpaRepository<InternalTransfer, Integer> {
}
