package it.step.repository;

import it.step.models.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodeRepo extends JpaRepository<Barcode, Integer> {
}
