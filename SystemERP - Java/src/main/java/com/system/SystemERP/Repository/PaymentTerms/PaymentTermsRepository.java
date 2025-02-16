package com.system.SystemERP.Repository.PaymentTerms;

import com.system.SystemERP.Entity.PaymentTerms.PaymentTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentTermsRepository extends JpaRepository<PaymentTerms, Integer> {
}