package com.otsnd.pokemonteambuilder.entities;

import jakarta.persistence.*;
import lombok.Data; // Si no usas Lombok, genera los getters/setters a mano

@Entity
@Table(name = "captured_pokemons")
@Data
public class CapturedPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único de ESTA captura (ej: Captura #504)

    // Guardamos solo el ID de referencia a la PokeAPI.
    // Cuando quieras saber sus tipos o stats, usas este ID para consultar la API.
    private Integer apiId; // Ej: 25 (Pikachu)

    private String name;   // Apodo o nombre de la especie

    private String spriteUrl; // Opcional: Para mostrar la imagen sin llamar a la API

    @Enumerated(EnumType.STRING)
    private PokemonStatus status; // ¿Está en TEAM o PC_BOX?

    // RELACIÓN: Muchos Pokémons pertenecen a Un Entrenador
    @ManyToOne
    @JoinColumn(name = "trainer_id") // Esto crea la columna 'trainer_id' en la base de datos
    private Trainer trainer;
}