package com.otsnd.pokemonteambuilder.controller;

import com.otsnd.pokemonteambuilder.dto.CaptureRequestDTO;
import com.otsnd.pokemonteambuilder.dto.TrainerRequestDTO;
import com.otsnd.pokemonteambuilder.entities.CapturedPokemon;
import com.otsnd.pokemonteambuilder.entities.Trainer;
import com.otsnd.pokemonteambuilder.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    // POST Crear Entrenador (Ya lo tienes)
    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody TrainerRequestDTO trainerDto) {
        Trainer createdTrainer = trainerService.createTrainer(trainerDto);
        return new ResponseEntity<>(createdTrainer, HttpStatus.CREATED);
    }

    // --- NUEVO ENDPOINT: Capturar Pokémon ---
    // Ejemplo de URL: POST http://localhost:8080/api/trainers/1/capture
    @PostMapping("/{id}/capture")
    public ResponseEntity<Trainer> capturePokemon(
            @PathVariable("id") Long trainerId,
            @RequestBody CaptureRequestDTO captureRequest) {

        Trainer updatedTrainer = trainerService.capturePokemon(trainerId, captureRequest.getPokemonName());

        return ResponseEntity.ok(updatedTrainer);
    }
    @GetMapping("/{id}/team")
    public ResponseEntity<List<CapturedPokemon>> getTrainerTeam(@PathVariable("id") Long id) {
        List<CapturedPokemon> team = trainerService.getTrainerTeam(id);
        return ResponseEntity.ok(team);
    }
}
