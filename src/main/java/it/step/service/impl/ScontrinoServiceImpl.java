package it.step.service.impl;

import it.step.models.Scontrino;
import it.step.repository.ScontrinoRepo;
import it.step.service.ScontrinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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

    @Override
    public List<Scontrino> getScontriniByData(Date data) {
        return repo.findByData(data);
    }

    @Override
    public Optional<Scontrino> deleteScontrinoByID(Integer id) {
        Optional<Scontrino> scontrino = repo.findById(id);
        repo.deleteById(id);
        return scontrino;
    }
}
