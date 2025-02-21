package com.system.SystemERP.Repository.TypesPayments;

import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesPaymentsRepository extends JpaRepository<TypesPayments, Integer> {
}
