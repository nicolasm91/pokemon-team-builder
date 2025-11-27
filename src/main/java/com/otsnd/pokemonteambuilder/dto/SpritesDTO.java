package com.otsnd.pokemonteambuilder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpritesDTO {

    // La PokeAPI usa snake_case ("front_default"), así que lo mapeamos a camelCase
    @JsonProperty("front_default")
    private String frontDefault;
}
