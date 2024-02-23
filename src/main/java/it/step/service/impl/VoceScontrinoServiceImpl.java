package it.step.service.impl;

import it.step.models.VoceScontrino;
import it.step.repository.VoceScontrinoRepo;
import it.step.service.VoceScontrinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VoceScontrinoServiceImpl implements VoceScontrinoService {

    @Autowired
    private VoceScontrinoRepo repo;

    @Override
    public VoceScontrino saveVoceScontrino(VoceScontrino voceScontrino) {
        return repo.save(voceScontrino);
    }
}
