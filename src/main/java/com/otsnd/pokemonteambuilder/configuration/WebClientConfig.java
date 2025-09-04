package com.otsnd.pokemonteambuilder.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${pokeapi.baseurl}")
    private String baseUrl;

    @Bean
    public WebClient PokemonServiceWebClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

}
