package it.step.repository;

import it.step.models.Scontrino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ScontrinoRepo extends JpaRepository<Scontrino, Integer> {

    List<Scontrino> findByData(Date data);

}
