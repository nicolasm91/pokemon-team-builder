package com.otsnd.pokemonteambuilder.exceptions;

public class PokeAPIServerErrorException extends RuntimeException {
    public PokeAPIServerErrorException(Integer message) {
        super(message.toString());
    }
}
