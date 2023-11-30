package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.interfaces.BaseCrud;
import com.dafon.trsearchback.model.*;
import com.dafon.trsearchback.service.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/users")
public class RegularUserController implements Serializable, BaseCrud<CreateRegularUser, UpdateRegularUserDto, ShowRegularUserDto> {

    private final RegularUserService regularUserService;
    private final AddressService addressService;

    @Autowired
    public RegularUserController(RegularUserService regularUserService, AddressService addressService) {
        this.regularUserService = regularUserService;
        this.addressService = addressService;
    }

//    @PostMapping
//    @Transactional
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<CreateRegularUserDto> createObject(@RequestBody @Valid CreateRegularUserDto dto, UriComponentsBuilder uriBuilder) {
//        var user = new RegularUser(dto);
//        regularUserService.createElement(user);
//
//        var uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(user.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);
//    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CreateRegularUser> createObject(@RequestBody @Valid CreateRegularUser dto, UriComponentsBuilder uriBuilder) {
        var address = new Address();

        address.setCity(dto.city());
        address.setNumber(dto.number());
        address.setDistrict(dto.district());
        address.setState(dto.state());
        address.setStreet(dto.street());
        address.setZipCode(dto.zipCode());
        address.setStatus(true);

        address = addressService.createElement(address);
        var user = new RegularUser((dto));
        user.setAddress(address);

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
    public ResponseEntity<ShowRegularUserDto> findObject(@PathVariable String email) {
        var user = regularUserService.findElement(email);
        return ResponseEntity.ok(new ShowRegularUserDto(user));
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
