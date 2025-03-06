package com.system.SystemERP.Services.BarCodeType;

import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Repository.BarcodeType.BarcodeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarCodeTypeServices {

    @Autowired
    private BarcodeTypeRepository barcodeTypeRepository;

    public Optional<BarCodeType> findById(Integer id){ return barcodeTypeRepository.findById(id); }
}
