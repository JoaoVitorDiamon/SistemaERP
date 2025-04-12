package com.system.SystemERP.Controller.Service;


import com.system.SystemERP.Dtos.Service.ServiceDTO;
import com.system.SystemERP.Entity.Service.Service;
import com.system.SystemERP.Services.Service.ServiceServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/services")
@Tag(name = "Serviços")
@Controller
public class ServiceController {

    private ServiceServices serviceServices;

    public ServiceController(ServiceServices serviceServices){
        this.serviceServices = serviceServices;
    }

    @PostMapping
    @Operation(summary = "Cria um serviço", description = "Cria um serviço")
    public ResponseEntity<Service> createService(@RequestBody ServiceDTO serviceDTO){
        var created = serviceServices.CreateService(serviceDTO);
        return ResponseEntity.created(URI.create("/servicos/" + created.toString())).build();
    }

    @GetMapping("/{idServico}")
    @Operation(summary = "Busca um serviço pelo id", description = "Busca um serviço pelo id")
    public ResponseEntity<Service> findById(@PathVariable Integer idServico){
        var exist = serviceServices.getById(idServico);
        return  ResponseEntity.ok(exist);
    }

    @GetMapping
    @Operation(summary = "Busca todos os serviços", description = "Busca todos os serviços")
    public ResponseEntity<List<Service>> findAll(){
        var listServices = serviceServices.getAll();
        return ResponseEntity.ok(listServices);
    }

    @DeleteMapping("/{idServico}")
    @Operation(summary = "Deleta um Servico pelo id", description = "Deleta um Servico pelo id")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        serviceServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
