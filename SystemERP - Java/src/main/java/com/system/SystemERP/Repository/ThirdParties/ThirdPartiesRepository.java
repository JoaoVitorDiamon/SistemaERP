package com.system.SystemERP.Repository.ThirdParties;

import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartiesRepository extends JpaRepository<ThirdParty,Integer> {
}
