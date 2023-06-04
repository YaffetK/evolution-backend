package com.example.evolution_backend.controller;

import com.example.evolution_backend.dto.CreateUserDto;
import com.example.evolution_backend.model.User;
import com.example.evolution_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/get-user")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }


    @GetMapping("/get-user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto user){

       return userService.createUser(user);
    }

}
