package com.system.SystemERP.Repository.CollectiveLicense;

import com.system.SystemERP.Entity.CollectiveLicense.CollectiveLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CollectiveLicenseRepository extends JpaRepository<CollectiveLicense, Integer> {
}
