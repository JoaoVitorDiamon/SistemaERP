package com.system.SystemERP.Services.JobVacancy;

import com.system.SystemERP.Dtos.JobVacancy.JobVacancyDTO;
import com.system.SystemERP.Entity.JobVacancy.JobVacancy;
import com.system.SystemERP.Repository.JobVacancy.JobVacancyRepository;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.Members.MembersServices;
import com.system.SystemERP.Services.Position.PositionServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobVacancyServices {


    private AddresServices addresServices;
    private MembersServices membersServices;
    private PositionServices positionServices;
    private JobVacancyRepository jobVacancyRepository;

    public JobVacancyServices(AddresServices addresServices, MembersServices membersServices, PositionServices positionServices, JobVacancyRepository jobVacancyRepository) {
        this.addresServices = addresServices;
        this.membersServices = membersServices;
        this.positionServices = positionServices;
        this.jobVacancyRepository = jobVacancyRepository;
    }

    public Integer createJobVacancy(JobVacancyDTO jobVacancyDTO) {
        var entity = jobVacancyDTO.toEntity(positionServices, membersServices, addresServices);
        entity = jobVacancyRepository.save(entity);
        return entity.getIdJobVacancy();
    }

    public JobVacancy findById(Integer Id) {
        return jobVacancyRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Vaga de Emprego nao encontrada!"));
    }

    public List<JobVacancy> getAll() {
        return jobVacancyRepository.findAll();
    }

    public void deleteById(Integer id) {
        var exists = jobVacancyRepository.existsById(id);
        if (!exists) {
            throw new EntityNotFoundException("Vaga de Emprego nao encontrada!");
        }
        jobVacancyRepository.deleteById(id);
    }

}
