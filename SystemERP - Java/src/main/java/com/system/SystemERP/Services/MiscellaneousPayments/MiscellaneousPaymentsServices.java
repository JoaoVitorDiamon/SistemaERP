package com.system.SystemERP.Services.MiscellaneousPayments;


import com.system.SystemERP.Dtos.MiscellaneousPayments.MiscellaneousPaymentsDTO;
import com.system.SystemERP.Entity.MiscellaneousPayments.MiscellaneousPayments;
import com.system.SystemERP.Repository.MiscellaneousPayments.MiscellaneousPaymentsRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiscellaneousPaymentsServices {

    @Autowired
    private MiscellaneousPaymentsRepository miscellaneousPaymentsRepository;

    @Autowired
    private AccountBankServices accountBankServices;

    @Autowired
    private TypesPaymentsServices typesPaymentsServices;

    public Integer createMiscellaneousPayments(MiscellaneousPaymentsDTO miscellaneousPaymentsDTO) {
        var miscellaneousPayments = miscellaneousPaymentsDTO.toEntity(typesPaymentsServices, accountBankServices);
        var savedID = miscellaneousPaymentsRepository.save(miscellaneousPayments);
        return savedID.getIdMiscellaneousPayments();

    }

    public Optional<MiscellaneousPayments> findByID(Integer Id) {
        return miscellaneousPaymentsRepository.findById(Id);
    }

    public List<MiscellaneousPayments> getAll() {
        return miscellaneousPaymentsRepository.findAll();
    }

    public void deleteByID(Integer ID) {
        var exists = miscellaneousPaymentsRepository.existsById(ID);
        if (exists) {
            miscellaneousPaymentsRepository.deleteById(ID);
        }
    }
}
