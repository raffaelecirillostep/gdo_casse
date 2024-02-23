package it.step.repository;

import it.step.models.Reparto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepartoRepo extends JpaRepository<Reparto, Integer> {
}
