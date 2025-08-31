package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.service.Asistance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String plataform;
    private final Asistance asistance;

    public HelloController(@Value("${spring.application.name}")String plataform, Asistance asistance) {
        this.plataform = plataform;
        this.asistance = asistance;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.asistance.generateGreeting(plataform);
    }
}
