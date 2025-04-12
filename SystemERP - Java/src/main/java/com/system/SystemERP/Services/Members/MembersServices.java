package com.system.SystemERP.Services.Members;


import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Repository.Members.MembersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MembersServices {
    private MembersRepository membersRepository;
    public MembersServices(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }



    public Members findById(Integer Id){
        return membersRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Membro nao encontrado"));
    }

}
