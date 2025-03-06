package com.system.SystemERP.Repository.Coin;

import com.system.SystemERP.Entity.Coin.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository  extends JpaRepository<Coin, Integer> {
}
