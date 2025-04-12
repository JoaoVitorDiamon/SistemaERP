package com.system.SystemERP.Services.Addres;

import com.system.SystemERP.Entity.Adress.Adress;
import com.system.SystemERP.Repository.Address.AddresRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AddresServices {

    private AddresRepository addresRepository;

    public AddresServices(AddresRepository addresRepository) {
        this.addresRepository = addresRepository;
    }

    public Adress findByID(Integer id){
        return addresRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Endereco nao encontrado"));
    }
}
