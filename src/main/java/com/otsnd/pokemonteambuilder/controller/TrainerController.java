package com.otsnd.pokemonteambuilder.controller;

// CORREGIDOS: Imports
import com.otsnd.pokemonteambuilder.dto.TrainerRequestDTO;
import com.otsnd.pokemonteambuilder.entities.Trainer;
import com.otsnd.pokemonteambuilder.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainers") // Ruta base unificada
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    // --- Este es el método POST que querías ---
    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody TrainerRequestDTO trainerDto) {

        Trainer createdTrainer = trainerService.createTrainer(trainerDto);

        // Retorna la entidad creada con el código de estado 201 Created
        return new ResponseEntity<>(createdTrainer, HttpStatus.CREATED);
    }

    // Aquí puedes agregar tus otros métodos (GET, PUT, DELETE)
    // @GetMapping("/{id}")
    // public ResponseEntity<Trainer> getTrainerById(@PathVariable("id") Long id) { ... }
}
