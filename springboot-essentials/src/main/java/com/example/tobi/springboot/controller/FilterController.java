package com.example.tobi.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/api/date")
    public String date() {
        return "date";
    }
}
