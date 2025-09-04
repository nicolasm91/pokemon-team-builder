package com.otsnd.pokemonteambuilder.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Value("${pokeapi.baseurl}")
    private String baseUrl;

    @Bean
    public RestClient blockingRestClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

}
