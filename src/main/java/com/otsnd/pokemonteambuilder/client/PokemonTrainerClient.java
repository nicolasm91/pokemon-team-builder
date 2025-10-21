package com.otsnd.pokemonteambuilder.client;

import com.otsnd.pokemonteambuilder.client.interfaces.TrainerClient;
import com.otsnd.pokemonteambuilder.dtos.TrainerDTO;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonTrainerClient implements TrainerClient {
    @Override
    public TrainerDTO GetTrainerById(String id) {
        return null;
    }
}
