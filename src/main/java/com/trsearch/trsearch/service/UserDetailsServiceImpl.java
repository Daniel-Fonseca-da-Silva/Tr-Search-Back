package com.trsearch.trsearch.service;

import com.trsearch.trsearch.model.UserCorp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserCorpRepository userCorpRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserCorp userCorp = userCorpRep.findByLoginCorp(username);

        if(userCorp != null)
            return User.withUsername(username).password(userCorp.getPasswordCorp()).roles("USER").build();
        throw new UsernameNotFoundException("User not found");

    }
}
