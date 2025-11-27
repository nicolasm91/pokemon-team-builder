package com.otsnd.pokemonteambuilder.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PokemonType {
    NORMAL("normal"),
    FIRE("fire"),
    WATER("water"),
    GRASS("grass"),
    ELECTRIC("electric"),
    ICE("ice"),
    FIGHTING("fighting"),
    POISON("poison"),
    GROUND("ground"),
    FLYING("flying"),
    PSYCHIC("psychic"),
    BUG("bug"),
    ROCK("rock"),
    GHOST("ghost"),
    DRAGON("dragon"),
    DARK("dark"),
    STEEL("steel"),
    FAIRY("fairy");

    @JsonValue
    private final String type;

    PokemonType(String type) {
        this.type = type;
    }
}