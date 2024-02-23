package it.step.repository;

import it.step.models.Prezzo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrezzoRepo extends JpaRepository<Prezzo, Integer> {
}
