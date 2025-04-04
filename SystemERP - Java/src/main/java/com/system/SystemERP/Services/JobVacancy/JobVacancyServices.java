package com.system.SystemERP.Services.JobVacancy;

import com.system.SystemERP.Dtos.JobVacancy.JobVacancyDTO;
import com.system.SystemERP.Entity.JobVacancy.JobVacancy;
import com.system.SystemERP.Repository.JobVacancy.JobVacancyRepository;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.Members.MembersServices;
import com.system.SystemERP.Services.Position.PositionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobVacancyServices {

    @Autowired
    private AddresServices addresServices;

    @Autowired
    private MembersServices membersServices;

    @Autowired
    private PositionServices positionServices;

    @Autowired
    private JobVacancyRepository jobVacancyRepository;


    public Integer createJobVacancy(JobVacancyDTO jobVacancyDTO) {
        var entity = jobVacancyDTO.toEntity(positionServices, membersServices, addresServices);
        entity = jobVacancyRepository.save(entity);
        return entity.getIdJobVacancy();
    }

    public Optional<JobVacancy> findById(Integer Id) {
        return jobVacancyRepository.findById(Id);
    }

    public List<JobVacancy> getAll() {
        var listJob = jobVacancyRepository.findAll();
        return listJob;
    }

    public void deleteById(Integer id) {
        var exists = jobVacancyRepository.existsById(id);
        if (exists) {
            jobVacancyRepository.deleteById(id);
        }
    }

}
