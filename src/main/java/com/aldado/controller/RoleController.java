package com.aldado.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security/roles")
public class RoleController {

    @PostMapping("/create/{role}")
    public ResponseEntity create(@PathVariable String role){
        return ResponseEntity.ok("Role created: " + role);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return ResponseEntity.ok("What are you looking for?");
    }
}
