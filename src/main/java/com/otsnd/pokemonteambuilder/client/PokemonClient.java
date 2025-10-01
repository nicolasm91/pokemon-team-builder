package com.otsnd.pokemonteambuilder.client;

import com.otsnd.pokemonteambuilder.dtos.PokemonDTO;

public interface PokemonClient {
    PokemonDTO GetPokemonById(String id);
}
