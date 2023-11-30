package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.model.*;
import com.dafon.trsearchback.security.TokenService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ShowTokenDto> loginRegular(@RequestBody @Valid ShowAuthenticationDto datasDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datasDto.email(), datasDto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateTokenRegular((RegularUser) authentication.getPrincipal());

        return ResponseEntity.ok(new ShowTokenDto(tokenJwt));
    }

    @PostMapping("corporate")
    public ResponseEntity<ShowTokenDto> loginCorporate(@RequestBody @Valid ShowAuthenticationDto datasDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datasDto.email(), datasDto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateTokenCorporate((CorporateUser) authentication.getPrincipal());

        return ResponseEntity.ok(new ShowTokenDto(tokenJwt));
    }


}
