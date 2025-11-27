package com.otsnd.pokemonteambuilder.service;

import com.otsnd.pokemonteambuilder.dto.TrainerRequestDTO;
import com.otsnd.pokemonteambuilder.dto.PokemonDTO;
import com.otsnd.pokemonteambuilder.entities.CapturedPokemon;
import com.otsnd.pokemonteambuilder.entities.Trainer;
import com.otsnd.pokemonteambuilder.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Importante para DB
import com.otsnd.pokemonteambuilder.entities.PokemonStatus;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private PokemonService pokemonService; // Inyectamos tu servicio de API existente

    public Trainer createTrainer(TrainerRequestDTO trainerDto) {
        // ... (tu código existente)
        Trainer newTrainer = new Trainer();
        newTrainer.setName(trainerDto.getName());
        newTrainer.setRegion(trainerDto.getRegion());
        return trainerRepository.save(newTrainer);
    }

    // --- NUEVO MÉTODO DE CAPTURA ---
    @Transactional // Asegura que si algo falla, no se guarde nada a medias
    public Trainer capturePokemon(Long trainerId, String pokemonName) {

        // 1. Buscar al Entrenador en tu Base de Datos
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        // 2. Validar que el Pokémon existe en la API externa (PokeAPI)
        // Usamos tu PokemonService. Si no existe, lanzará tu PokemonNotFoundException
        PokemonDTO apiPokemon = pokemonService.getById(pokemonName);

        // 3. Crear la nueva entidad CapturedPokemon
        CapturedPokemon newCapture = new CapturedPokemon();
        newCapture.setName(apiPokemon.getName());
        newCapture.setApiId(apiPokemon.getId().intValue()); // Guardamos el ID de referencia (ej: 25)

        // --- AQUÍ GUARDAMOS LA IMAGEN ---
        if (apiPokemon.getSprites() != null) {
            newCapture.setSpriteUrl(apiPokemon.getSprites().getFrontDefault());
        }

        // 4. Usar el método inteligente del Entrenador para asignarlo (Equipo vs Caja)
        trainer.addPokemon(newCapture);

        // 5. Guardar los cambios (CascadeType.ALL guardará también al pokemon)
        return trainerRepository.save(trainer);
    }
    public List<CapturedPokemon> getTrainerTeam(Long trainerId) {
        // 1. Buscamos al entrenador
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        // 2. Filtramos la lista para obtener solo los del equipo (TEAM)
        return trainer.getPokemons().stream()
                .filter(p -> p.getStatus() == PokemonStatus.TEAM)
                .collect(Collectors.toList());
    }
}