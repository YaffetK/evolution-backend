package com.example.evolution_backend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class WorkOut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false )
    private User user;

    @OneToMany(mappedBy = "workOut")
    private Set<Excercice> excercices;
}
