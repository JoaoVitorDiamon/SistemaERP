package com.system.SystemERP.Services.ThirdParties;

import com.system.SystemERP.Dtos.ThirdParties.ThirdPartiesDTO;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import com.system.SystemERP.Repository.ThirdParties.ThirdPartiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThirdPartiesServices {
    private final ThirdPartiesRepository thirdPartiesRepository;

    public ThirdPartiesServices(ThirdPartiesRepository thirdPartiesRepository) {
        this.thirdPartiesRepository = thirdPartiesRepository;
    }

    public Integer createThirdParty(ThirdPartiesDTO thirdPartiesDTO) {
        var thirdParty = thirdPartiesDTO.toEntity();
        var savedThirdParty = thirdPartiesRepository.save(thirdParty);
        return savedThirdParty.getThirdPartyId();
    }

    public Optional<ThirdParty> getById(Integer id) {
        return thirdPartiesRepository.findById(id);
    }

    public List<ThirdParty> getAll() {
        return thirdPartiesRepository.findAll();
    }

    public void delete(Integer id) {
        thirdPartiesRepository.deleteById(id);
    }
}
