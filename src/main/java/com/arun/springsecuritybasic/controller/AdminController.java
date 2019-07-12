package com.arun.springsecuritybasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/home")
    public ResponseEntity<String> adminPage(){
        return ResponseEntity.ok("admin");
    }

    @GetMapping("/user/home")
    public ResponseEntity<String> userPage(){
        return ResponseEntity.ok("user");
    }
}
