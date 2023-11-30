package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.interfaces.BaseCrud;
import com.dafon.trsearchback.model.Address;
import com.dafon.trsearchback.service.AddressService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/address")
public class AddressController implements Serializable, BaseCrud<CreateAddressDto, UpdateAddressDto, ShowDatasAddressDto> {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    @Transactional
    @Secured({"ROLE_CORPORATE", "ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CreateAddressDto> createObject(@RequestBody @Valid CreateAddressDto dto, UriComponentsBuilder uriBuilder) {
        var address = new Address(dto);

        addressService.createElement(address);

        var uri = uriBuilder.path("/api/v1/address/{id}").buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    @Transactional
    @Secured({"ROLE_CORPORATE", "ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UpdateAddressDto> updateObject(@RequestBody @Valid UpdateAddressDto dto) {
        var addressUpdated = addressService.updateElement(dto);
        return ResponseEntity.ok(new UpdateAddressDto(addressUpdated));
    }

    @GetMapping("/{id}")
    @Secured({"ADMIN_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowDatasAddressDto> findObject(@PathVariable String id) {
        var address = addressService.findElement(id);
        return ResponseEntity.ok(new ShowDatasAddressDto(address));
    }

    @GetMapping("/user/{id}")
    @Secured({"ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowDatasAddressDto> getObjectByUser(@PathVariable UUID id) {
        var address = addressService.findElementByUser(id);
        return ResponseEntity.ok(new ShowDatasAddressDto(address));
    }

    @GetMapping("/corporate/{id}")
    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowDatasAddressDto> getObjectByCorporate(@PathVariable UUID id) {
        var address = addressService.findElementByCorporate(id);
        return ResponseEntity.ok(new ShowDatasAddressDto(address));
    }

    @GetMapping("/establishment/{id}")
    @Secured({"ROLE_CORPORATE", "ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowDatasAddressDto> getObjectByEstablishment(@PathVariable UUID id) {
        var address = addressService.findElementByEstablishment(id);
        return ResponseEntity.ok(new ShowDatasAddressDto(address));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Secured({"ROLE_CORPORATE", "ROLE_USER"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> removeObject(@PathVariable String id) {
        addressService.removeElement(id);
        return ResponseEntity.noContent().build();
    }

}
