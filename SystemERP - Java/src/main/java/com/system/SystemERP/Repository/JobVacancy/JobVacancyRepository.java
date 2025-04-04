package com.system.SystemERP.Repository.JobVacancy;

import com.system.SystemERP.Entity.JobVacancy.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobVacancyRepository extends JpaRepository<JobVacancy, Integer> {
}
