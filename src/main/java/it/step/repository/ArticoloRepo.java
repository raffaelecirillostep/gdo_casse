package it.step.repository;

import it.step.models.Articolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticoloRepo extends JpaRepository<Articolo, Integer> {
}
