package com.system.SystemERP.Services.TypesPayments;

import com.system.SystemERP.Dtos.TypesPayments.TypesPaymentsDTO;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Repository.TypesPayments.TypesPaymentsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TypesPaymentsServices {
    private TypesPaymentsRepository typesPaymentsRepository;

    public TypesPaymentsServices(TypesPaymentsRepository typesPaymentsRepository) {
        this.typesPaymentsRepository = typesPaymentsRepository;
    }

    public Integer createTypePayment(TypesPaymentsDTO typesPaymentsDTO) {
        var typePayment = new TypesPayments(
                null,
                typesPaymentsDTO.name().name(),
                Instant.now(),
                null);

        var typePaymentSaved = typesPaymentsRepository.save(typePayment);
        return typePaymentSaved.getIdTypesPayments();

    }

    public TypesPayments findByID(Integer id) {
        return typesPaymentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tipo de pagamento nao encontrado"));
    }

    public List<TypesPayments> findAll() {
        return typesPaymentsRepository.findAll();
    }

    public void deleteByID(Integer id) {
        var exists = typesPaymentsRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Tipo de pagamento nao encontrado");
        typesPaymentsRepository.deleteById(id);
    }
}
