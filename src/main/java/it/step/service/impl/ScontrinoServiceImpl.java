package it.step.service.impl;

import it.step.models.Scontrino;
import it.step.models.VoceScontrino;
import it.step.repository.ScontrinoRepo;
import it.step.service.ScontrinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScontrinoServiceImpl implements ScontrinoService {

    @Autowired
    private ScontrinoRepo repo;

    @Override
    public Scontrino createScontrino(Scontrino scontrino) {
        return repo.save(scontrino);
    }

    @Override
    public Optional<Scontrino> getScontrinoByID(Integer id) {
        return repo.findById(id);
    }
}