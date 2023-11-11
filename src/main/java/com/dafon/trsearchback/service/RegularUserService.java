package com.dafon.trsearchback.service;

import com.dafon.trsearchback.dto.UpdateRegularUserDto;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.repository.RegularUserRepository;

import com.dafon.trsearchback.security.SecurityConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularUserService {

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
        user.updateInformation(dto);
        return user;
    }

    public RegularUser findElement(String email) {
        return regularUserRepository.findByEmail(email);
    }

//    public Page<ShowDatasRegularUserDto> findElements(Pageable pagination) {
//        return regularUserRepository.findAll(pagination).map(ShowDatasRegularUserDto::new);
//    }

    public void removeElement(String email) {
        var user = regularUserRepository.findByEmail(email);
        user.desactivate();
    }
}
