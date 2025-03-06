package com.system.SystemERP.Repository.MiscellaneousPayments;

import com.system.SystemERP.Entity.MiscellaneousPayments.MiscellaneousPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MiscellaneousPaymentsRepository extends JpaRepository<MiscellaneousPayments, Integer> {
}
