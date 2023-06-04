package com.example.evolution_backend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "ecercises" )
@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Excercice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "workOut_id",nullable = false)
    private WorkOut workOut;
}
