package com.otsnd.pokemonteambuilder.dto;

import lombok.Data;

@Data
public class CaptureRequestDTO {
    private String pokemonName; // El nombre del pokemon a capturar (ej: "charmander")
}