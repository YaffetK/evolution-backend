package com.example.evolution_backend.dto;


import com.example.evolution_backend.model.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CreateUserDto {


    private String firstname;
    private String lastname;
    private String email;

    private Role role;

    public CreateUserDto(String firstname, String lastname, String email, Role role) {
    }
}
