package com.otsnd.pokemonteambuilder.entities;

import jakarta.persistence.*; // O javax.persistence.* si usas Spring Boot 2

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String region;

    public void setName(String name) {
    }

    public void setRegion(String region) {
    }

    // Relación: Un entrenador puede tener un equipo activo
    // @OneToOne(mappedBy = "trainer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Team activeTeam;

    // ... getters y setters, constructor, etc.
}