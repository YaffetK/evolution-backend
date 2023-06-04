package com.example.evolution_backend.repository;

import com.example.evolution_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Boolean findUserByEmail(String email);

}
