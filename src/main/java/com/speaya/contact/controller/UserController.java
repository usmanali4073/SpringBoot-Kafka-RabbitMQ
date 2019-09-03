package com.speaya.contact.controller;

import com.speaya.contact.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping
    public String getUser() {
        return "Test";
    }

    @PostMapping("{Name}")
    public ResponseEntity<String> addUser(@PathVariable String Name) {
        kafkaService.send(Name);
        return ResponseEntity.ok(Name);
    }
}
