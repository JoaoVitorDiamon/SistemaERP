package com.system.SystemERP.Controller.ThirdParties;

import com.system.SystemERP.Dtos.ThirdParties.ThirdPartiesDTO;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import com.system.SystemERP.Services.ThirdParties.ThirdPartiesServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/third-parties")
@Tag(name = "Terceiros")
@Controller
public class ThirdPartiesController {

    private final ThirdPartiesServices thirdPartiesServices;

    public ThirdPartiesController(ThirdPartiesServices thirdPartiesServices) {
        this.thirdPartiesServices = thirdPartiesServices;
    }

    @PostMapping
    @Operation(summary = "Cria um terceiro", description = "Cria um novo terceiro")
    public ResponseEntity<ThirdParty> createThirdParty(@RequestBody ThirdPartiesDTO thirdPartiesDTO) {
        var created = thirdPartiesServices.createThirdParty(thirdPartiesDTO);
        return ResponseEntity.created(URI.create("/third-parties/" + created)).build();
    }

    @GetMapping("/{idTerceiros}")
    @Operation(summary = "Busca um terceiro pelo ID", description = "Retorna um terceiro pelo ID")
    public ResponseEntity<ThirdParty> findById(@PathVariable Integer idTerceiros) {
        var exist = thirdPartiesServices.getById(idTerceiros);
        return exist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Busca todos os terceiros", description = "Retorna uma lista de todos os terceiros")
    public ResponseEntity<List<ThirdParty>> findAll() {
        var listThirdParties = thirdPartiesServices.getAll();
        return ResponseEntity.ok(listThirdParties);
    }

    @DeleteMapping("/{idTerceiros}")
    @Operation(summary = "Deleta um terceiro pelo ID", description = "Remove um terceiro pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Integer idTerceiros) {
        thirdPartiesServices.delete(idTerceiros);
        return ResponseEntity.noContent().build();
    }
}
