package com.system.SystemERP.Services.TypesPayments;

import com.system.SystemERP.Dtos.TypesPayments.TypesPaymentsDTO;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Repository.TypesPayments.TypesPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TypesPaymentsServices {

    @Autowired
    private TypesPaymentsRepository typesPaymentsRepository;


    public Integer createTypePayment(TypesPaymentsDTO typesPaymentsDTO) {
        var typePayment = new TypesPayments(
                null,
                typesPaymentsDTO.name().name(),
                Instant.now(),
                null);

        var typePaymentSaved = typesPaymentsRepository.save(typePayment);
        return typePaymentSaved.getId();

    }

    public Optional<TypesPayments> findByID(Integer id) {
        return typesPaymentsRepository.findById(id);
    }

    public List<TypesPayments> findAll() {
        return typesPaymentsRepository.findAll();
    }

    public void deleteByID(Integer id) {
        var exists = typesPaymentsRepository.existsById(id);

        if (exists) {
            typesPaymentsRepository.deleteById(id);
        }

    }
}
