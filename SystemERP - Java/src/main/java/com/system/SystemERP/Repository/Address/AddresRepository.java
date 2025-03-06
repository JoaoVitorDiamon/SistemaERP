package com.system.SystemERP.Repository.Address;

import com.system.SystemERP.Entity.Adress.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresRepository extends JpaRepository<Adress, Integer> {
}
