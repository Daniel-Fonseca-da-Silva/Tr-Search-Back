package com.dafon.trsearchback.service;

import com.dafon.trsearchback.repository.CorporateRepository;
import com.dafon.trsearchback.repository.RegularUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private RegularUserRepository regularUserRepository;

    @Autowired
    private CorporateRepository corporateRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var regularUserFound = regularUserRepository.findByEmail(email);

        if (regularUserFound != null)
            return regularUserFound;

        return corporateRepository.findByEmail(email);


    }

}
