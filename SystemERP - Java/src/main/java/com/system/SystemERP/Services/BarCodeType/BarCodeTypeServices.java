package com.system.SystemERP.Services.BarCodeType;

import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Repository.BarcodeType.BarcodeTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BarCodeTypeServices {

    private BarcodeTypeRepository barcodeTypeRepository;

    public BarCodeTypeServices(BarcodeTypeRepository barcodeTypeRepository) {
        this.barcodeTypeRepository = barcodeTypeRepository;
    }

    public BarCodeType findById(Integer id){ return barcodeTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Codigo de barra nao encontrado!"));}
}
