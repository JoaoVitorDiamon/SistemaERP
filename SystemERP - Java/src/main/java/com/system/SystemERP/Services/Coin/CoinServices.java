package com.system.SystemERP.Services.Coin;

import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Repository.Coin.CoinRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CoinServices {

    private CoinRepository coinRepository;

    public CoinServices(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    public Coin findByID(Integer id){
        return coinRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Moeda nao encontrada"));
    }
}
