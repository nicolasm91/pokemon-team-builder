package com.otsnd.pokemonteambuilder.controller;

import com.otsnd.pokemonteambuilder.dtos.TrainerDTO;
import com.otsnd.pokemonteambuilder.service.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/trainer")
public class TrainerController {
    private final TrainerService service;

    public TrainerController(TrainerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDTO> getTrainerById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.service.getById(id));
    }
}
