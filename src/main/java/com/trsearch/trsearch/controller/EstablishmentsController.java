package com.trsearch.trsearch.controller;

import com.trsearch.trsearch.model.Establishments;
import com.trsearch.trsearch.service.EstablishmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/establishments")
public class EstablishmentsController {

    private EstablishmentService establishmentService = new EstablishmentService();

    @GetMapping
    public List<Establishments> get() {
        return establishmentService.getEstablishments();
    }

}
