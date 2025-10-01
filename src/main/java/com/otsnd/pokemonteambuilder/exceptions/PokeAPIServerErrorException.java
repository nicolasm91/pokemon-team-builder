package com.otsnd.pokemonteambuilder.exceptions;

public class PokeAPIServerErrorException extends RuntimeException {
    public PokeAPIServerErrorException(String message) {
        super(message);
    }
}
