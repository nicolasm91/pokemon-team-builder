package com.otsnd.pokemonteambuilder.dto;

// Este DTO se usará para recibir la "pegada POST"
public class TrainerRequestDTO {

    private String name;
    private String region; // Coincide con la Entidad y el Service

    // Getters y Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
}
