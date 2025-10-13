package com.otsnd.pokemonteambuilder.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonDeserialize
@NoArgsConstructor
public class PokemonDTO {
    private Long id;
    private String name;
    private Integer order;
    private List<TypesDTO> types;
}


