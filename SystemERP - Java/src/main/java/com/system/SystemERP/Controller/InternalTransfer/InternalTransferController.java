package com.system.SystemERP.Controller.InternalTransfer;


import com.system.SystemERP.Dtos.InternalTransfer.InternalTransferDTO;
import com.system.SystemERP.Entity.InternalTransfer.InternalTransfer;
import com.system.SystemERP.Services.InternalTransfer.InternalTransferServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/internalTransfer")
public class InternalTransferController {

    @Autowired
    private InternalTransferServices internalTransferServices;


    @PostMapping
    public ResponseEntity<String> createInternalTransfer(@RequestBody InternalTransferDTO internalTransferDTO) {
        var saved = internalTransferServices.createInternalTransfer(internalTransferDTO);
        return ResponseEntity.created(URI.create("/internalTransfer" + saved.toString()))
                .build();
    }

    @GetMapping("/{idInternalTransfer}")
    public ResponseEntity<InternalTransfer> findInternalTransferByID(@PathVariable Integer idInternalTransfer) {
        var internalTransfer = internalTransferServices.findById(idInternalTransfer);
        return ResponseEntity.ok(internalTransfer);

    }

    @GetMapping
    public ResponseEntity<List<InternalTransfer>> findAll() {
        var savedList = internalTransferServices.getAll();
        return ResponseEntity.ok(savedList);

    }

    @DeleteMapping("/{idInternalTransfer}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idInternalTransfer) {
        internalTransferServices.deleteByID(idInternalTransfer);
        return ResponseEntity.noContent()
                .build();
    }
}

