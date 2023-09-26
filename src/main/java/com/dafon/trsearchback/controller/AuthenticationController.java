package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.DatasAuthenticationDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DatasAuthenticationDto datasDto) {
        var token = new UsernamePasswordAuthenticationToken(datasDto.email(), datasDto.password());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }


}
