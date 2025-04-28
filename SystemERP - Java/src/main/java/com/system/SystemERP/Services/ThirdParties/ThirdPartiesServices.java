package com.system.SystemERP.Services.ThirdParties;

import com.system.SystemERP.Dtos.ThirdParties.ThirdPartiesDTO;
import com.system.SystemERP.Entity.ThirdParties.ThirdParty;
import com.system.SystemERP.Repository.ThirdParties.ThirdPartiesRepository;
import com.system.SystemERP.Services.Addres.AddresServices;
import com.system.SystemERP.Services.ClientType.ClientTypeServices;
import com.system.SystemERP.Services.Coin.CoinServices;
import com.system.SystemERP.Services.Enterprise.EnterpriseServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPartiesServices {
    private final ThirdPartiesRepository thirdPartiesRepository;
    private final AddresServices addresServices;
    private final ClientTypeServices clientTypeServices;
    private final EnterpriseServices enterpriseServices;
    private final CoinServices coinServices;


    public ThirdPartiesServices(ThirdPartiesRepository thirdPartiesRepository, AddresServices addresServices, ClientTypeServices clientTypeServices, EnterpriseServices enterpriseServices, CoinServices coinServices) {
        this.thirdPartiesRepository = thirdPartiesRepository;
        this.addresServices = addresServices;
        this.clientTypeServices = clientTypeServices;
        this.enterpriseServices = enterpriseServices;
        this.coinServices = coinServices;
    }


    public Integer createThirdParty(ThirdPartiesDTO thirdPartiesDTO) {
        var thirdParty = thirdPartiesDTO.toEntity(clientTypeServices, coinServices, enterpriseServices, addresServices);
        var savedThirdParty = thirdPartiesRepository.save(thirdParty);
        return savedThirdParty.getThirdPartyId();
    }

    public ThirdParty getById(Integer id) {
        return thirdPartiesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Terceiros nao encontrado!"));
    }

    public List<ThirdParty> getAll() {
        return thirdPartiesRepository.findAll();
    }

    public void delete(Integer id) {
        var exists = thirdPartiesRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException("Terceiros nao encontrado!");
        thirdPartiesRepository.deleteById(id);
    }

    public void updateThirdParty(Integer id, ThirdPartiesDTO thirdPartiesDTO){
        var exists = thirdPartiesRepository.existsById(id);
        if(!exists) throw new EntityNotFoundException("Terceiro nao encontrado");
        var thirdParty = thirdPartiesDTO.toEntity(clientTypeServices, coinServices, enterpriseServices, addresServices);
        thirdParty.setThirdPartyId(id);
        thirdPartiesRepository.save(thirdParty);
    }
}
