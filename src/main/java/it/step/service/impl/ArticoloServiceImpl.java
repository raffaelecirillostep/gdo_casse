package it.step.service.impl;

import it.step.models.Articolo;
import it.step.repository.ArticoloRepo;
import it.step.service.ArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticoloServiceImpl implements ArticoloService {

    @Autowired
    private ArticoloRepo repo;

    @Override
    public Optional<Articolo> getArticoloByID(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Articolo> getArticoloByBarcode(String barcode) {
        return repo.findByBarcodes_Codice(barcode);
    }

    @Override
    public List<Articolo> getAllArticoli() {
        return repo.findAll();
    }
}
