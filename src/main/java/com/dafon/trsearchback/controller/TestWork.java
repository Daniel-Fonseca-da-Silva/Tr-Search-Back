package com.dafon.trsearchback.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@SecurityRequirement(name = "bearer-key")
public class TestWork {

    @GetMapping("admin")
    @Secured({"ROLE_ADMIN"})
    public String work() {
        return "ADMIN spring!!";
    }

    @GetMapping("user")
    @Secured({"ROLE_USER"})
    public String test() {
        return "USER spring!!";
    }

}
