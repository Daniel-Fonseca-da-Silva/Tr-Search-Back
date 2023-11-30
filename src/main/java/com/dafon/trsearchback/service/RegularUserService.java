package com.dafon.trsearchback.service;

import com.dafon.trsearchback.dto.UpdateRegularUserDto;
import com.dafon.trsearchback.exception.Custom404Exception;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.repository.RegularUserRepository;
import com.dafon.trsearchback.security.SecurityConfigurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RegularUserService implements Serializable {

    private final RegularUserRepository regularUserRepository;
    private final SecurityConfigurations securityConfigurations;

    @Autowired
    public RegularUserService(RegularUserRepository regularUserRepository, SecurityConfigurations securityConfigurations) {
        this.regularUserRepository = regularUserRepository;
        this.securityConfigurations = securityConfigurations;
    }

    public void createElement(RegularUser user) {
        var encoder = securityConfigurations.passwordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        regularUserRepository.save(user);
    }

    public RegularUser updateElement(UpdateRegularUserDto dto) {
        var user = regularUserRepository.findByEmail(dto.email());

        if(user != null) {
            user.updateInformation(dto);
            return user;
        } else {
            throw new Custom404Exception("Email not found, please verify!");
        }
    }

    public RegularUser findElement(String email) {
        var user = regularUserRepository.findByEmail(email);

        if(user != null) {
            return user;
        } else {
            throw new Custom404Exception("User not found, please verify!");
        }
    }

    public void removeElement(String email) {
        var user = regularUserRepository.findByEmail(email);

        if(user != null) {
            user.desactivate();
        } else {
            throw new Custom404Exception("User not found, please verify!");
        }
    }

}
