package com.otsnd.pokemonteambuilder.controller;

import com.otsnd.pokemonteambuilder.dtos.PokemonDTO;
import com.otsnd.pokemonteambuilder.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pokemon")
public class PokemonController {
    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO>  getPokemonById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.service.getById(id));
    }
}
