package org.springboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestComtroller {

    @GetMapping("/home")
    public String simpleGet(){
        return "welcome";
    }
}
