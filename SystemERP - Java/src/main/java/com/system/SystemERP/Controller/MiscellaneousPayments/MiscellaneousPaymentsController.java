package com.system.SystemERP.Controller.MiscellaneousPayments;


import com.system.SystemERP.Dtos.MiscellaneousPayments.MiscellaneousPaymentsDTO;
import com.system.SystemERP.Entity.MiscellaneousPayments.MiscellaneousPayments;
import com.system.SystemERP.Services.MiscellaneousPayments.MiscellaneousPaymentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/miscellaneousPayments")
public class MiscellaneousPaymentsController {

    @Autowired
    private MiscellaneousPaymentsServices miscellaneousPaymentsServices;


    @PostMapping
    public ResponseEntity<MiscellaneousPayments> createMiscellaneousPayments(@RequestBody MiscellaneousPaymentsDTO miscellaneousPaymentsDTO){
        var savedId = miscellaneousPaymentsServices.createMiscellaneousPayments(miscellaneousPaymentsDTO);
        return ResponseEntity.created(
                URI.create("/miscellaneousPayments" +
                savedId.toString()))
                .build();
    }


    @GetMapping("/{idMiscellaneousPayments}")
    public ResponseEntity<MiscellaneousPayments> findByID(@PathVariable Integer idMiscellaneousPayments){
        var miscellaneousPayments = miscellaneousPaymentsServices.findByID(idMiscellaneousPayments);
        return miscellaneousPayments.isPresent()
                ? ResponseEntity.ok(miscellaneousPayments.get())
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<MiscellaneousPayments>> getAll(){
        var listMiscellaneousPayments = miscellaneousPaymentsServices.getAll();
        return ResponseEntity.ok(listMiscellaneousPayments);
    }


    @DeleteMapping("/{idMiscellaneousPayments}")
    public ResponseEntity<Void> deleteByID(@PathVariable Integer idMiscellaneousPayments){
        miscellaneousPaymentsServices.deleteByID(idMiscellaneousPayments);
        return ResponseEntity.noContent().build();
    }

}
