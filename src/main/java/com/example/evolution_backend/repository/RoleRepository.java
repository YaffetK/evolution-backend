package com.example.evolution_backend.repository;

import com.example.evolution_backend.model.ERole;
import com.example.evolution_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(ERole name);
    Role findRoleByName(ERole name);
}
