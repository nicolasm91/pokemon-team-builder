package com.otsnd.pokemonteambuilder.controller;

import com.otsnd.pokemonteambuilder.exceptions.PokeAPIServerErrorException;
import com.otsnd.pokemonteambuilder.exceptions.PokemonNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pokemon")
public class PokemonController {
    private final RestClient restClient;

    public PokemonController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getPokemonById(@PathVariable("id") Integer id) {
        Map<String, Object> pokemon = this.restClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, PokemonController::HandleNotFound)
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> HandleServerError(id))
                .body(ParameterizedTypeReference.forType(HashMap.class));

        return ResponseEntity.ok(pokemon);
    }

    private static void HandleNotFound(HttpRequest request, ClientHttpResponse response) throws IOException {
        throw new PokemonNotFoundException(response.getStatusCode());
    }

    private static void HandleServerError(Integer id) {
        throw new PokeAPIServerErrorException(id);
    }
}
