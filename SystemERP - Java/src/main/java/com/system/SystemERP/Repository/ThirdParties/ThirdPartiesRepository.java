package com.system.SystemERP.Repository.ThirdParties;

import com.system.SystemERP.Entity.ThirdParties.ThirdParties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartiesRepository extends JpaRepository<ThirdParties,Integer> {
}
