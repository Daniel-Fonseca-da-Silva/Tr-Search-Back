package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.interfaces.BaseCrud;
import com.dafon.trsearchback.model.*;
import com.dafon.trsearchback.service.CorporateUserService;

import com.dafon.trsearchback.service.EstablishmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/corporate")
public class CorporateUserController implements BaseCrud<CreateCorporateUserDto, UpdateCorporateUserDto, AllDatasCorporateUserDto> {

    private final CorporateUserService corporateUserService;
    private final EstablishmentService establishmentService;

    @Autowired
    public CorporateUserController(CorporateUserService corporateUserService, EstablishmentService establishmentService) {
        this.corporateUserService = corporateUserService;
        this.establishmentService = establishmentService;
    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CreateCorporateUserDto> createObject(@RequestBody @Valid CreateCorporateUserDto dto, UriComponentsBuilder uriBuilder) {
        var corporate = new CorporateUser(dto);

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
    public ResponseEntity<AllDatasCorporateUserDto> findObject(@PathVariable String email) {
        var corporate = corporateUserService.findElementByEmail(email);
        return ResponseEntity.ok(new AllDatasCorporateUserDto(corporate));
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

    @DeleteMapping("/{email}")
    @Secured({"ROLE_CORPORATE"})
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> removeObject(@PathVariable String email) {
        corporateUserService.removeElement(email);
        return ResponseEntity.noContent().build();
    }

}
