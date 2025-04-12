package com.system.SystemERP.Services.PaymentTerms;


import com.system.SystemERP.Dtos.PaymentTerms.PaymentTermsDTOS;
import com.system.SystemERP.Entity.PaymentTerms.PaymentTerms;
import com.system.SystemERP.Repository.PaymentTerms.PaymentTermsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTermsServices {
    private final PaymentTermsRepository paymentTermsRepository;

    public PaymentTermsServices(PaymentTermsRepository paymentTermsRepository) {
        this.paymentTermsRepository = paymentTermsRepository;
    }

    public Integer createPaymentTerms(PaymentTermsDTOS paymentTermsDTOS) {
        var paymentTerms = new PaymentTerms(
                null,
                paymentTermsDTOS.nome().name(),
                null,
                null);

        var savedTerms = paymentTermsRepository.save(paymentTerms);
        return savedTerms.getIdPaymentTerms();
    }

    public PaymentTerms findByIDPaymentTerms(Integer id) {
        return paymentTermsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Termo de Pagamento nao Encontrado!"));
    }

    public List<PaymentTerms> getAll() {
        return paymentTermsRepository.findAll();
    }

    public void delete(Integer id) {
        var termsExists = paymentTermsRepository.existsById(id);
        if (!termsExists) throw new EntityNotFoundException("Termo de Pagamento nao Encontrado!");
        paymentTermsRepository.deleteById(id);
    }
}
