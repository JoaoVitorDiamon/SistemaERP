package com.system.SystemERP.Controller.JobVacancy;


import com.system.SystemERP.Dtos.JobVacancy.JobVacancyDTO;
import com.system.SystemERP.Entity.JobVacancy.JobVacancy;
import com.system.SystemERP.Services.JobVacancy.JobVacancyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jobVacancy")
public class JobVacancyController {

    @Autowired
    private JobVacancyServices jobVacancyServices;


    @PostMapping
    public ResponseEntity<String> createJobVacancy(JobVacancyDTO jobVacancyDTO) {
        var entity = jobVacancyServices.createJobVacancy(jobVacancyDTO);
        return ResponseEntity.created(URI.create("/jobVacancy" + entity.toString())).build();
    }

    @GetMapping("/{idJobVacancy}")
    public ResponseEntity<JobVacancy> findById(@PathVariable Integer idJobVacancy) {
        var entity = jobVacancyServices.findById(idJobVacancy);
        return entity.isPresent()
                ? ResponseEntity.ok(entity.get())
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<JobVacancy>> getAll(){
        var entity = jobVacancyServices.getAll();
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{idJobVacancy}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer idJobVacancy){

        jobVacancyServices.deleteById(idJobVacancy);
        return ResponseEntity.noContent().build();
    }

}
