package com.otsnd.pokemonteambuilder.controller;

import com.otsnd.pokemonteambuilder.exceptions.PokeAPIServerErrorException;
import com.otsnd.pokemonteambuilder.exceptions.PokemonNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping("api/v2/pokemon")
public class ReactivePokemonController {
    private final WebClient webClient;

    public ReactivePokemonController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/{id}")
    public Mono<?> getPokemonById(@PathVariable("id")  Integer id) {
        return this.webClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->Mono.error(new PokemonNotFoundException(clientResponse.statusCode())))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse ->Mono.error(new PokeAPIServerErrorException(id)))
                .bodyToMono(ParameterizedTypeReference.forType(HashMap.class))
                .onErrorResume(throwable -> Mono.just(Collections.singletonMap(String.format("error fetching pokemon %s", 2), throwable.getMessage())));
    }
}
