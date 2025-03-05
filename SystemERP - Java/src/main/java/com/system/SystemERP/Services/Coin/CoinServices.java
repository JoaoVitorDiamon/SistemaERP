package com.system.SystemERP.Services.Coin;

import com.system.SystemERP.Entity.Coin.Coin;
import com.system.SystemERP.Repository.Coin.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoinServices {

    @Autowired
    private CoinRepository coinRepository;


    public Optional<Coin> findByID(Integer id){
        return coinRepository.findById(id);
    }
}
