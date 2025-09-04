package com.otsnd.pokemonteambuilder.exceptions;

import org.springframework.http.HttpStatusCode;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(HttpStatusCode code) {
        super("pokemon not found - " + code);
    }
}
