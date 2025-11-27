package com.otsnd.pokemonteambuilder.client;

import com.otsnd.pokemonteambuilder.client.interfaces.PokemonClient;
import com.otsnd.pokemonteambuilder.dto.PokemonDTO;
import com.otsnd.pokemonteambuilder.exceptions.PokeAPIServerErrorException;
import com.otsnd.pokemonteambuilder.exceptions.PokemonNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.io.IOException;

@Repository
public class PokemonApiClient implements PokemonClient {
    private final RestClient restClient;

    public PokemonApiClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public PokemonDTO GetPokemonById(String id) {
        return this.restClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, PokemonApiClient::HandleNotFound)
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> HandleServerError(id))
                .body(PokemonDTO.class);
    }

    private static void HandleNotFound(HttpRequest request, ClientHttpResponse response) throws IOException {
        throw new PokemonNotFoundException(response.getStatusCode());
    }

    private static void HandleServerError(String id) {
        throw new PokeAPIServerErrorException(id);
    }
}
