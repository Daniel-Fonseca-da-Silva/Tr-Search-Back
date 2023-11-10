package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.service.RegularUserService;
import com.dafon.trsearchback.interfaces.BaseCrud;
import com.dafon.trsearchback.security.SecurityConfigurations;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;


@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/users")
public class RegularUserController implements BaseCrud<AllDatasRegularUserDto> {

    private final RegularUserService regularUserService;
    private final SecurityConfigurations securityConfigurations;

    @Autowired
    public RegularUserController(RegularUserService regularUserService, SecurityConfigurations securityConfigurations) {
        this.regularUserService = regularUserService;
        this.securityConfigurations = securityConfigurations;
    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<DatasRegularUserDto> createObject(@RequestBody @Valid DatasRegularUserDto dto, UriComponentsBuilder uriBuilder) {
        var user = new RegularUser(dto);

        var encoder = securityConfigurations.passwordEncoder();

        user.setPassword(encoder.encode(dto.password()));

        regularUserService.createElement(user);

        var uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    @Transactional
    @Secured({"ROLE_USER"})
    public ResponseEntity<AllDatasRegularUserDto> updateObject(@RequestBody @Valid DatasRegularUserUpdateDto dto) {
        var userUpdated = regularUserService.updateElement(dto);
        return ResponseEntity.ok(new AllDatasRegularUserDto(userUpdated));
    }

    @GetMapping("/{id}")
    @Secured({"ROLE_USER"})
    public ResponseEntity<AllDatasRegularUserDto> findObject(@PathVariable UUID id) {
        var user = regularUserService.findElement(id);
        return ResponseEntity.ok(new AllDatasRegularUserDto(user));
    }

    @GetMapping
    @Secured({"ROLE_USER"})
    public ResponseEntity<Page<ShowDatasRegularUserDto>> findObjects(Pageable pagination) {
      var page = regularUserService.findElements(pagination);
      return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Secured({"ROLE_USER"})
    public ResponseEntity<Void> removeObject(@PathVariable UUID id) {
        regularUserService.removeElement(id);
        return ResponseEntity.noContent().build();
    }

}
