package com.system.SystemERP.Repository.Storage;

import com.system.SystemERP.Entity.Storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {
}
