package com.dafon.trsearchback.service;

import com.dafon.trsearchback.repository.RegularUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private RegularUserRepository regularUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return regularUserRepository.findByEmail(email);
    }
}
