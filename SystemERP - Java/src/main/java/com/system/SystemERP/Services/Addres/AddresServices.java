package com.system.SystemERP.Services.Addres;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Repository.Address.AddresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddresServices {

    @Autowired
    private AddresRepository addresRepository;

    public Optional<Adress> findByID(Integer id){
        return addresRepository.findById(id);
    }
}
