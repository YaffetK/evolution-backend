package com.example.evolution_backend.service;

import com.example.evolution_backend.dto.CreateUserDto;
import com.example.evolution_backend.model.User;
import com.example.evolution_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    public User getUserById(long id){
       return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + "doesn´t exist"));
    }

    public ResponseEntity<User> createUser(CreateUserDto user) {

        CreateUserDto _user = new CreateUserDto(user.getFirstname(),user.getLastname(),user.getEmail(),user.getRole());

        User user1 = new User(user.getFirstname(), user.getLastname(), user.getEmail());


        System.out.println(_user.getEmail());
        try{

            if (userRepository.findUserByEmail(user1.getEmail())){
                 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (_user.getRole().equals("ROLE_USER")) {
                System.out.println(_user.getRole());
                user1.setRole(_user.getRole());
            } else if(_user.getRole().equals("ROLE_ADMIN")) {
                user1.setRole(_user.getRole());
            }
                userRepository.save(user1);
                return new ResponseEntity<>(user1,HttpStatus.CREATED);



        }catch(Error e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
