package com.otsnd.pokemonteambuilder.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonDeserialize
@NoArgsConstructor
public class TrainerDTO {
    private String name;
    private String gender;
}

