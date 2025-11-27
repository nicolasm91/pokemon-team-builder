package com.otsnd.pokemonteambuilder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypesDTO {
    private Integer slot;
    private TypeItemDTO type;
}
