package com.otsnd.pokemonteambuilder.service;

import com.otsnd.pokemonteambuilder.client.interfaces.PokemonClient;
import com.otsnd.pokemonteambuilder.dtos.PokemonDTO;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private final PokemonClient client;

    public PokemonService(PokemonClient client) {
        this.client = client;
    }

    public PokemonDTO getById(String id) {
        return this.client.GetPokemonById(id);
    }
}
