package com.otsnd.pokemonteambuilder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@JsonDeserialize
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDTO {
    private Long id;
    private String name;
    private Integer order;
    private List<TypesDTO> types;
    private SpritesDTO sprites;
}


