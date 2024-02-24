package it.step.repository;

import it.step.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepo extends JpaRepository<Stock, Integer> {
    Optional<Stock> findByArticoloID(Integer articoloID);
}
