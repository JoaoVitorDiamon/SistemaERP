package com.system.SystemERP.Services.InternalTransfer;


import com.system.SystemERP.Dtos.InternalTransfer.InternalTransferDTO;
import com.system.SystemERP.Entity.InternalTransfer.InternalTransfer;
import com.system.SystemERP.Repository.InternalTransfer.InternalTransferRepository;
import com.system.SystemERP.Services.AccountBank.AccountBankServices;
import com.system.SystemERP.Services.TypesPayments.TypesPaymentsServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternalTransferServices {

    private InternalTransferRepository internalTransferRepository;
    private AccountBankServices accountBankServices;
    private TypesPaymentsServices typesPaymentsServices;


    public InternalTransferServices(InternalTransferRepository internalTransferRepository, AccountBankServices accountBankServices, TypesPaymentsServices typesPaymentsServices) {
        this.internalTransferRepository = internalTransferRepository;
        this.accountBankServices = accountBankServices;
        this.typesPaymentsServices = typesPaymentsServices;
    }

    public Integer createInternalTransfer(InternalTransferDTO internalTransferDTO) {
        var internalTransfer = internalTransferDTO.toEntity(accountBankServices, typesPaymentsServices);
        var internalTransferSaved = internalTransferRepository.save(internalTransfer);
        return internalTransferSaved.getIDInternalTransfer();
    }

    public InternalTransfer findById(Integer Id) {return internalTransferRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Transferencia não encontrada"));}

    public List<InternalTransfer> getAll() {
        return internalTransferRepository.findAll();
    }

    public void deleteByID(Integer ID) {
        var exists = internalTransferRepository.existsById(ID);
        if (!exists) throw new EntityNotFoundException("Transferencia não encontrada");
        internalTransferRepository.deleteById(ID);
    }


}
