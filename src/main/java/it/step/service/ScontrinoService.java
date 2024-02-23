package it.step.service;

import it.step.models.Scontrino;
import java.util.Optional;

public interface ScontrinoService {

    Scontrino createScontrino(Scontrino scontrino);
    Optional<Scontrino> getScontrinoByID(Integer id);
}
