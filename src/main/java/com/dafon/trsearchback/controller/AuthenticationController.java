package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.DatasAuthenticationDto;
import com.dafon.trsearchback.dto.DatasTokenDto;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DatasAuthenticationDto datasDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datasDto.email(), datasDto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateToken((RegularUser) authentication.getPrincipal());

        return ResponseEntity.ok(new DatasTokenDto(tokenJwt));
    }


}
