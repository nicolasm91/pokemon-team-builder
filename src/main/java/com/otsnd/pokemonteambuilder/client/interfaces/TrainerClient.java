package com.otsnd.pokemonteambuilder.client.interfaces;

import com.otsnd.pokemonteambuilder.dto.TrainerDTO;

public interface TrainerClient {
    TrainerDTO GetTrainerById(String id);
}
