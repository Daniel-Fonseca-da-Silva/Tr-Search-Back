package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.*;
import com.dafon.trsearchback.interfaces.BaseCrud;
import com.dafon.trsearchback.model.*;
import com.dafon.trsearchback.service.EstablishmentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("api/v1/establishment")
public class EstablishmentController implements Serializable, BaseCrud<CreateEstablishmentDto, UpdateEstablishmentDto, ShowDatasEstablishmentDto> {

    private final EstablishmentService establishmentService;

    @Autowired
    public EstablishmentController(EstablishmentService establishmentService) {
     this.establishmentService = establishmentService;
    }

    @PostMapping
    @Transactional
    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CreateEstablishmentDto> createObject(@RequestBody @Valid CreateEstablishmentDto dto, UriComponentsBuilder uriBuilder) {
        var establishment = new Establishment(dto);

        establishmentService.createElement(establishment);

        var uri = uriBuilder.path("/api/v1/establishment/{id}").buildAndExpand(establishment.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    @Transactional
    @Secured({"ROLE_CORPORATE"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UpdateEstablishmentDto> updateObject(@RequestBody @Valid UpdateEstablishmentDto dto) {
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

    @DeleteMapping("/{code}")
    @Secured({"ROLE_CORPORATE"})
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> removeObject(@PathVariable String code) {
        establishmentService.removeElement(code);
        return ResponseEntity.noContent().build();
    }


}
