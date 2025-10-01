package com.otsnd.pokemonteambuilder.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
@JsonDeserialize
public class PokemonDTO {
    private Long id;
    private String name;
    private Integer order;
}


