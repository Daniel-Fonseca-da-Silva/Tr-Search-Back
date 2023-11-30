package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.model.*;
import com.dafon.trsearchback.service.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.util.*;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/establishment")
public class EstablishmentController implements Serializable {

    private final EstablishmentService establishmentService;

    private final AddressService addressService;

    private final CorporateUserService corporateUserService;

    @Autowired
    public EstablishmentController(EstablishmentService establishmentService, AddressService addressService, CorporateUserService corporateUserService) {
     this.establishmentService = establishmentService;
     this.addressService = addressService;
     this.corporateUserService = corporateUserService;
    }

    @PostMapping("create/{email}")
    @Transactional
//    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CreateEstablishmentDto> createObject(@PathVariable String email, @RequestBody @Valid CreateEstablishmentDto dto, UriComponentsBuilder uriBuilder) {

        CorporateUser corporateUser = this.corporateUserService.findElementByEmail(email);

        if(corporateUser != null) {
            var address = new Address();

            address.setCity(dto.city());
            address.setNumber(dto.number());
            address.setDistrict(dto.district());
            address.setState(dto.state());
            address.setStreet(dto.street());
            address.setZipCode(dto.zipCode());
            address.setStatus(true);
            address = addressService.createElement(address);

            var establishment = new Establishment(dto);
            establishment.setAddress(address);
            establishment.setCorporateUser(corporateUser);
            this.establishmentService.createElement(establishment);

            var uri = uriBuilder.path("/api/v1/establishment/{id}").buildAndExpand(establishment.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
//    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UpdateEstablishmentDto> updateObject(@RequestBody UpdateEstablishmentDto dto) {
        var establishmentUpdated = establishmentService.updateElement(dto);
        return ResponseEntity.ok(new UpdateEstablishmentDto(establishmentUpdated));
    }

    @GetMapping("/category/{category}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowDatasEstablishmentDto> findObjectByCategory(@PathVariable Category category) {
        var establishment = establishmentService.findElementByCategory(category);
        return ResponseEntity.ok(new ShowDatasEstablishmentDto(establishment));
    }

    @GetMapping("/name/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowDatasEstablishmentDto> findObject(@PathVariable String name) {
        var establishment = establishmentService.findElement(name);
        return ResponseEntity.ok(new ShowDatasEstablishmentDto(establishment));
    }

    @GetMapping("/code/{code}")
    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShowDatasEstablishmentCorporateDto> findObjectByCode(@PathVariable String code) {
        var establishment = establishmentService.findElementByCode(code);
        return ResponseEntity.ok(new ShowDatasEstablishmentCorporateDto(establishment));
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Page<ShowDatasEstablishmentDto>> findObjects(Pageable pagination) {
        var page = establishmentService.findElements(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/establishments/{corporateUserId}")
    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<ShowDatasEstablishmentCorporateDto>> findEstablishmentsObject(@PathVariable UUID corporateUserId) {
        List<Establishment> establishments = establishmentService.findElementsEstablishment(corporateUserId);

        List<ShowDatasEstablishmentCorporateDto> dtos = establishments.stream()
                .map(ShowDatasEstablishmentCorporateDto::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{code}")
    @Secured({"ROLE_CORPORATE"})
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> removeObject(@PathVariable String code) {
        establishmentService.removeElement(code);
        return ResponseEntity.noContent().build();
    }


}
