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


@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/corporate")
public class CorporateUserController implements BaseCrud<CreateCorporateUserDto, UpdateCorporateUserDto, ShowCorporateUserDto> {

    private final CorporateUserService corporateUserService;
    private final AddressService addressService;

    @Autowired
    public CorporateUserController(CorporateUserService corporateUserService, AddressService addressService) {
        this.corporateUserService = corporateUserService;
        this.addressService = addressService;
    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CreateCorporateUserDto> createObject(@RequestBody @Valid CreateCorporateUserDto dto, UriComponentsBuilder uriBuilder) {


        var address = new Address();

        address.setCity(dto.city());
        address.setNumber(dto.number());
        address.setDistrict(dto.district());
        address.setState(dto.state());
        address.setStreet(dto.street());
        address.setZipCode(dto.zipCode());
        address.setStatus(true);

        address = addressService.createElement(address);
        var corporate = new CorporateUser((dto));
        corporate.setAddress(address);

        corporateUserService.createElement(corporate);

        var uri = uriBuilder.path("/api/v1/corporate/{id}").buildAndExpand(corporate.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }

    @PutMapping
    @Secured({"ROLE_CORPORATE"})
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UpdateCorporateUserDto> updateObject(@RequestBody @Valid UpdateCorporateUserDto dto) {
        var corporateUpdated = corporateUserService.updateElement(dto);
        return ResponseEntity.ok(new UpdateCorporateUserDto(corporateUpdated));
    }

    @GetMapping("/{email}")
    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowCorporateUserDto> findObject(@PathVariable String email) {
        var corporate = corporateUserService.findElementByEmail(email);
        return ResponseEntity.ok(new ShowCorporateUserDto(corporate));
    }

    @DeleteMapping("/{email}")
    @Secured({"ROLE_CORPORATE"})
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> removeObject(@PathVariable String email) {
        corporateUserService.removeElement(email);
        return ResponseEntity.noContent().build();
    }

}
