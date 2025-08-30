package com.dmgorraiz.task_manager_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final Asistance asistance;

    public HelloController(Asistance asistance) {
        this.asistance = asistance;
    }

    @GetMapping("/")
    public String hello() {
        return this.asistance.generateGreeting();
    }
}
