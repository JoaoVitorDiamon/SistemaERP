package com.system.SystemERP.Controller.AccountingCode;


import com.system.SystemERP.Dtos.AccountingCode.AccountingCodeDTO;
import com.system.SystemERP.Entity.AccountingCode.AccountingCode;
import com.system.SystemERP.Services.AccountingCode.AccountingCodeServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Codigos Contabeis")
@RequestMapping("/accountingCode")
@CrossOrigin(origins = "http://localhost:")

public class AccountingCodeController {

    @Autowired
    private AccountingCodeServices accountingCodeServices;

    @PostMapping
    public ResponseEntity<AccountingCode> createAccountingCode(@RequestBody  AccountingCodeDTO accountingCodeDTO) {
        try {
            var saved = accountingCodeServices.createAccountingCode(accountingCodeDTO);
            return ResponseEntity.created(URI.create("/accountingCode" + saved.toString())).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/{idAccountingCode}")
    public ResponseEntity<AccountingCode> findByID(@PathVariable Integer idAccountingCode) {
        var accountingCode = accountingCodeServices.findByID(idAccountingCode);

        return accountingCode.isPresent()
                ? ResponseEntity.ok(accountingCode.get())
                : ResponseEntity.notFound().build();
    }


    @GetMapping
    public ResponseEntity<List<AccountingCode>> findAll() {
        var listsAccountingCode = accountingCodeServices.findAll();

        return ResponseEntity.ok(listsAccountingCode);
    }

    @DeleteMapping("/{idAccountingCode}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idAccountingCode) {
        accountingCodeServices.deleteByID(idAccountingCode);
        return ResponseEntity.noContent().build();

    }


}
