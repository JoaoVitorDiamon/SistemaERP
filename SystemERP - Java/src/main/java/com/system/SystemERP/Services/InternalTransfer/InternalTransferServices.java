package com.system.SystemERP.Services.InternalTransfer;


import com.system.SystemERP.Dtos.InternalTransfer.InternalTransferDTO;
import com.system.SystemERP.Entity.InternalTransfer.InternalTransfer;
import com.system.SystemERP.Repository.InternalTransfer.InternalTransferRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternalTransferServices {


    @Autowired
    private InternalTransferRepository internalTransferRepository;

    @Autowired
    private AccountBankServices accountBankServices;

    @Autowired
    private TypesPaymentsServices typesPaymentsServices;

    public Integer createInternalTransfer(InternalTransferDTO internalTransferDTO) {
        var internalTransfer = internalTransferDTO.toEntity(accountBankServices, typesPaymentsServices);
        var internalTransferSaved = internalTransferRepository.save(internalTransfer);
        return internalTransferSaved.getIDInternalTransfer();
    }

    public Optional<InternalTransfer> findById(Integer Id) {
        return internalTransferRepository.findById(Id);
    }

    public List<InternalTransfer> getAll() {
        return internalTransferRepository.findAll();
    }

    public void deleteByID(Integer ID) {
        var exists = internalTransferRepository.existsById(ID);
        if (exists) {
            internalTransferRepository.deleteById(ID);
        }
    }


}
