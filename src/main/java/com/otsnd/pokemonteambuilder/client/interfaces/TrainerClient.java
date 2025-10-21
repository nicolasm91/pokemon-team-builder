package com.otsnd.pokemonteambuilder.client.interfaces;

import com.otsnd.pokemonteambuilder.dtos.TrainerDTO;

public interface TrainerClient {
    TrainerDTO GetTrainerById(String id);
}
