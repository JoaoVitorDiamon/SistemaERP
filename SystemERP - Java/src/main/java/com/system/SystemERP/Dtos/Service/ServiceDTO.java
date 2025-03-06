package com.system.SystemERP.Dtos.Service;

import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Entity.BarCodeType.BarCodeType;
import com.system.SystemERP.Entity.Enterprise.Enterprise;
import com.system.SystemERP.Entity.SerialNumberControl.SerialNumberControl;
import com.system.SystemERP.Entity.Service.Service;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.BarCodeType.BarCodeTypeServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import com.system.SystemERP.Services.SerialNumberControl.SerialNumberControlService;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalTime;

public record ServiceDTO (
        String ProductRef,
        String Label,
        boolean Sale,
        boolean Purchase,
        Integer IdSerialNumberControl,
        Integer IdBarCodeType,
        String Barcode,
        String Description,
        String Notes,
        LocalTime Duration,
        double Price,
        double MinimumPrice,
        int ICMS,
        double TaxCMSP,
        Integer IdSalesCode,
        Integer IdExportCode,
        Integer IdImportCode,
        Integer IdPurchaseCode,
        Integer IdEnterprise,
        Integer IdAddress

){
    public Service toEntity(SerialNumberControlService serialNumberControlService, BarCodeTypeServices barCodeTypeServices, AccountingCodeServices accountingCodeServices, EnterpriseServices enterpriseServices, AddresServices addresServices) {
        return new Service(
                null,
                ProductRef,
                Label,
                Sale,
                Purchase,
                fetchSerialNumberControlById(IdSerialNumberControl, serialNumberControlService),
                fetchBarCodeTypeById(IdBarCodeType,barCodeTypeServices),
                Description,
                Notes,
                Duration,
                Price,
                MinimumPrice,
                ICMS,
                TaxCMSP,
                fetchAccountingCodeByID(IdSalesCode, accountingCodeServices),
                fetchAccountingCodeByID(IdExportCode, accountingCodeServices),
                fetchAccountingCodeByID(IdImportCode, accountingCodeServices),
                fetchAccountingCodeByID(IdPurchaseCode, accountingCodeServices),
                fetchEnterpriseById(IdEnterprise, enterpriseServices),
                fetchAdressByID(IdAddress, addresServices)

        );
    }
    private SerialNumberControl fetchSerialNumberControlById(Integer id, SerialNumberControlService serialNumberControlService){
        var serialNumberControl = serialNumberControlService.findById(id);
        return serialNumberControl.orElseThrow(
                () -> new EntityNotFoundException("Numero de Serie não nencontrado"));
    }

    private BarCodeType fetchBarCodeTypeById(Integer id, BarCodeTypeServices barCodeTypeServices){
        var barCodeType = barCodeTypeServices.findById(id);
        return barCodeType.orElseThrow(
                () -> new EntityNotFoundException("Codigo de barras não encontrado"));
        }

    private AccountingCode fetchAccountingCodeByID(Integer Id, AccountingCodeServices accountingCodeServices) {
        var accountingCode = accountingCodeServices.findByID(Id);
        return accountingCode.orElseThrow(
                () -> new EntityNotFoundException("Tipo nao encontrado"));
    }

    private Enterprise fetchEnterpriseById(Integer Id, EnterpriseServices enterpriseServices){
        var enterprise = enterpriseServices.findByID(Id);
        return enterprise.orElseThrow(
                () -> new EntityNotFoundException("Empresa não encontrada"));
    }

    private Adress fetchAdressByID(Integer Id, AddresServices addresServices) {
        var addres = addresServices.findByID(Id);
        return addres.orElseThrow(
                () -> new EntityNotFoundException("Endereço nao encontrado"));
    }
}
