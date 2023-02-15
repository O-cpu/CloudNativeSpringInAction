package com.example.catalogservice.controller;

import com.example.catalogservice.config.PolarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final PolarProperties polarProperties;

    public HelloController(PolarProperties polarProperties) {
        this.polarProperties = polarProperties;
    }

    @GetMapping("/")
    public String getMainPage() {
        return polarProperties.getGreeting();
    }
}
