package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.service.RegularUserService;
import com.dafon.trsearchback.interfaces.BaseCrud;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/users")
public class RegularUserController implements BaseCrud<CreateRegularUserDto, UpdateRegularUserDto, AllDatasRegularUserDto> {

    private final RegularUserService regularUserService;

    @Autowired
    public RegularUserController(RegularUserService regularUserService) {
        this.regularUserService = regularUserService;
    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CreateRegularUserDto> createObject(@RequestBody @Valid CreateRegularUserDto dto, UriComponentsBuilder uriBuilder) {
        var user = new RegularUser(dto);
        regularUserService.createElement(user);

        var uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    @Transactional
    @Secured({"ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UpdateRegularUserDto> updateObject(@RequestBody @Valid UpdateRegularUserDto dto) {
        var userUpdated = regularUserService.updateElement(dto);
        return ResponseEntity.ok(new UpdateRegularUserDto(userUpdated));
    }

    @GetMapping("/{email}")
    @Secured({"ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AllDatasRegularUserDto> findObject(@PathVariable String email) {
        var user = regularUserService.findElement(email);
        return ResponseEntity.ok(new AllDatasRegularUserDto(user));
    }

    @DeleteMapping("/{email}")
    @Transactional
    @Secured({"ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> removeObject(@PathVariable String email) {
        regularUserService.removeElement(email);
        return ResponseEntity.noContent().build();
    }

}
