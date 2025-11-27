package com.otsnd.pokemonteambuilder.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Asumiendo que el equipo tiene 6 "slots" (referencias a Pokémon que serían otra entidad)
    // Por simplicidad, solo agregamos el nombre del equipo y el límite
    private static final int MAX_MEMBERS = 6;

    // Relación One-to-One con Trainer (un entrenador tiene un equipo activo)
    @OneToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;

    // ... getters y setters, constructor, etc.
}
