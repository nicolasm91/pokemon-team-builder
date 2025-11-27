package com.otsnd.pokemonteambuilder.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainers")
@Data
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String region;

    // --- NUEVO: La lista de sus pokémons ---
    // 'mappedBy' significa que la clase CapturedPokemon es la dueña de la relación (campo 'trainer')
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CapturedPokemon> pokemons = new ArrayList<>();

    // --- LÓGICA DE EQUIPO AUTOMÁTICA ---
    // Este método es clave: decide solo si va al equipo o a la caja
    public void addPokemon(CapturedPokemon pokemon) {
        // 1. Contamos cuántos tienes en el equipo actualmente
        long enEquipo = this.pokemons.stream()
                .filter(p -> p.getStatus() == PokemonStatus.TEAM)
                .count();

        // 2. Si tienes menos de 6, entra al equipo. Si no, a la caja.
        if (enEquipo < 6) {
            pokemon.setStatus(PokemonStatus.TEAM);
        } else {
            pokemon.setStatus(PokemonStatus.PC_BOX);
        }

        // 3. Vinculamos ambas partes
        pokemon.setTrainer(this);
        this.pokemons.add(pokemon);
    }
}