package com.dafon.trsearchback.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class TestWork {

    @GetMapping("work")
    public String test() {
        return "Worked spring!";
    }

}
