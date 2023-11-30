package com.dafon.trsearchback.service;

import com.dafon.trsearchback.dto.UpdateCorporateUserDto;
import com.dafon.trsearchback.model.CorporateUser;
import com.dafon.trsearchback.repository.CorporateUserRepository;
import com.dafon.trsearchback.security.SecurityConfigurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class CorporateUserService implements Serializable {

    private final CorporateUserRepository corporateUserRepository;
    private final SecurityConfigurations securityConfigurations;

    @Autowired
    public CorporateUserService(CorporateUserRepository corporateUserRepository, SecurityConfigurations securityConfigurations) {
        this.corporateUserRepository = corporateUserRepository;
        this.securityConfigurations = securityConfigurations;
    }

    public void createElement(CorporateUser corporate) {
        var encoder = securityConfigurations.passwordEncoder();
        corporate.setPassword(encoder.encode(corporate.getPassword()));
        this.corporateUserRepository.save(corporate);
    }

    public CorporateUser updateElement(UpdateCorporateUserDto dto) {
        var corporate = corporateUserRepository.findByEmail(dto.email());
        corporate.updateInformation(dto);
        return corporate;
    }

    public CorporateUser findElementByEmail(String email) {
        return corporateUserRepository.findByEmail(email);
    }

    public void removeElement(String email) {
        corporateUserRepository.findByEmail(email).desactivate();
    }

}
