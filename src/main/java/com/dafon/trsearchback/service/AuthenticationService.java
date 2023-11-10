package com.dafon.trsearchback.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.dafon.trsearchback.repository.CorporateUserRepository;
import com.dafon.trsearchback.repository.RegularUserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    private final RegularUserRepository regularUserRepository;
    private final CorporateUserRepository corporateUserRepository;

    @Autowired
    public AuthenticationService(RegularUserRepository regularUserRepository, CorporateUserRepository corporateUserRepository) {
        this.regularUserRepository = regularUserRepository;
        this.corporateUserRepository = corporateUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var regularUserFound = regularUserRepository.findByEmail(email);

        if (regularUserFound != null)
            return regularUserFound;

        return corporateUserRepository.findByEmail(email);


    }

}
