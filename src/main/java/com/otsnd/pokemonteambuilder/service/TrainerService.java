package com.otsnd.pokemonteambuilder.service;

import com.otsnd.pokemonteambuilder.client.interfaces.TrainerClient;
import com.otsnd.pokemonteambuilder.dtos.TrainerDTO;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private final TrainerClient client;

    public TrainerService(TrainerClient client) {
        this.client = client;
    }

    public TrainerDTO getById(String id) {
        return this.client.GetTrainerById(id);
    }
}
