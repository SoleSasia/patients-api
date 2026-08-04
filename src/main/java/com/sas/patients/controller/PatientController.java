package com.sas.patients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PatientController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Patient Controller";
    }
}
