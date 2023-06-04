package com.example.evolution_backend.controller;

import com.example.evolution_backend.model.ERole;
import com.example.evolution_backend.model.Role;
import com.example.evolution_backend.repository.RoleRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor

public class RoleController {

    private final RoleRepository roleRepository;


    @PostMapping("/create-role")
    public ResponseEntity<Role> createRole(@RequestBody Role role){

        Role _role = new Role();
        System.out.println();
        _role.setName(role.getName());

        roleRepository.save(_role);

        return new ResponseEntity<>(_role, HttpStatus.OK);

    }

}
