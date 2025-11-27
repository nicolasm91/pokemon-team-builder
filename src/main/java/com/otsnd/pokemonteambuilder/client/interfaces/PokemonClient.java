package com.otsnd.pokemonteambuilder.client.interfaces;

import com.otsnd.pokemonteambuilder.dto.PokemonDTO;

public interface PokemonClient {
    PokemonDTO GetPokemonById(String id);
}
