package com.dafon.trsearchback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import com.dafon.trsearchback.dto.DatasAuthenticationDto;
import com.dafon.trsearchback.dto.DatasTokenDto;
import com.dafon.trsearchback.model.CorporateUser;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.security.TokenService;

@RestController()
@RequestMapping("api/v1/login")
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping("user")
    public ResponseEntity<DatasTokenDto> loginRegular(@RequestBody @Valid DatasAuthenticationDto datasDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datasDto.email(), datasDto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateTokenRegular((RegularUser) authentication.getPrincipal());

        return ResponseEntity.ok(new DatasTokenDto(tokenJwt));
    }

    @PostMapping("corporate")
    public ResponseEntity<DatasTokenDto> loginCorporate(@RequestBody @Valid DatasAuthenticationDto datasDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datasDto.email(), datasDto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateTokenCorporate((CorporateUser) authentication.getPrincipal());

        return ResponseEntity.ok(new DatasTokenDto(tokenJwt));
    }


}
