package com.dafon.trsearchback.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class TestWork {

    @GetMapping("test")
    @Secured({"ROLE_ADMIN"})
    public String work() {
        return "ADMIN spring!";
    }

    @GetMapping("work")
    @Secured({"ROLE_USER"})
    public String test() {
        return "USER spring!";
    }

}
