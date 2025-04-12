package com.system.SystemERP.Services.MiscellaneousPayments;


import com.system.SystemERP.Dtos.MiscellaneousPayments.MiscellaneousPaymentsDTO;
import com.system.SystemERP.Entity.MiscellaneousPayments.MiscellaneousPayments;
import com.system.SystemERP.Repository.MiscellaneousPayments.MiscellaneousPaymentsRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiscellaneousPaymentsServices {


    private MiscellaneousPaymentsRepository miscellaneousPaymentsRepository;
    private AccountBankServices accountBankServices;
    private TypesPaymentsServices typesPaymentsServices;


    public MiscellaneousPaymentsServices(MiscellaneousPaymentsRepository miscellaneousPaymentsRepository, AccountBankServices accountBankServices, TypesPaymentsServices typesPaymentsServices) {
        this.miscellaneousPaymentsRepository = miscellaneousPaymentsRepository;
        this.accountBankServices = accountBankServices;
        this.typesPaymentsServices = typesPaymentsServices;
    }


    public Integer createMiscellaneousPayments(MiscellaneousPaymentsDTO miscellaneousPaymentsDTO) {
        var miscellaneousPayments = miscellaneousPaymentsDTO.toEntity(typesPaymentsServices, accountBankServices);
        var savedID = miscellaneousPaymentsRepository.save(miscellaneousPayments);
        return savedID.getIdMiscellaneousPayments();

    }

    public MiscellaneousPayments findByID(Integer Id) {
        return miscellaneousPaymentsRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Pagamento diverso nao encontrado!"));
    }

    public List<MiscellaneousPayments> getAll() {
        return miscellaneousPaymentsRepository.findAll();
    }

    public void deleteByID(Integer ID) {
        var exists = miscellaneousPaymentsRepository.existsById(ID);
        if (!exists) throw new EntityNotFoundException("Pagamento diverso nao encontrado!");
        miscellaneousPaymentsRepository.deleteById(ID);
    }
}
