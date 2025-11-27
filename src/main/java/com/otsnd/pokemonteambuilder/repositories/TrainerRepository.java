package com.otsnd.pokemonteambuilder.repositories;

// CORREGIDO: Importa la entidad de tu paquete
import com.otsnd.pokemonteambuilder.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    // Spring Data JPA proporciona métodos como save() automáticamente
}
