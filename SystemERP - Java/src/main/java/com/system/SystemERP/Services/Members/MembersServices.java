package com.system.SystemERP.Services.Members;


import com.system.SystemERP.Entity.Members.Members;
import com.system.SystemERP.Repository.Members.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembersServices {

    @Autowired
    private MembersRepository membersRepository;

    public Optional<Members> findById(Integer Id){
        return membersRepository.findById(Id);
    }

}
