package it.step.repository;

import it.step.models.Articolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticoloRepo extends JpaRepository<Articolo, Integer> {
    Optional<Articolo> findByBarcodes_Codice(String codiceBarcode);
}
