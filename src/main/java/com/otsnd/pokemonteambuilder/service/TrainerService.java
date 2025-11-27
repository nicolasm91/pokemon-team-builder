package com.otsnd.pokemonteambuilder.service;

// CORREGIDOS: Imports apuntando a tus paquetes
import com.otsnd.pokemonteambuilder.dto.TrainerRequestDTO;
import com.otsnd.pokemonteambuilder.entities.Trainer;
import com.otsnd.pokemonteambuilder.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    // Método para crear un nuevo entrenador (la "pegada POST")
    public Trainer createTrainer(TrainerRequestDTO trainerDto) {

        // 1. Convertir el DTO (name/region) a Entidad
        Trainer newTrainer = new Trainer();
        newTrainer.setName(trainerDto.getName());
        newTrainer.setRegion(trainerDto.getRegion()); // Ahora coincide

        // 2. Persistir la Entidad
        return trainerRepository.save(newTrainer);
    }

    // Puedes agregar tu método GET aquí si quieres
    // public Trainer getById(String id) { ... }
}