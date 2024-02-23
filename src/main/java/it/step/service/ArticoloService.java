package it.step.service;

import it.step.models.Articolo;

import java.util.List;
import java.util.Optional;

public interface ArticoloService {

    Optional<Articolo> getArticoloByID(Integer id);
    Optional<Articolo> getArticoloByBarcode(String barcode);
    List<Articolo> getAllArticoli();

}
