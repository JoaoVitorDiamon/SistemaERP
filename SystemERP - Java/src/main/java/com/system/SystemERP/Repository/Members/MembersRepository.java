package com.system.SystemERP.Repository.Members;

import com.system.SystemERP.Entity.Members.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
}
