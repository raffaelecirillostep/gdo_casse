package it.step.service.impl;

import it.step.models.Reparto;
import it.step.repository.RepartoRepo;
import it.step.service.RepartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RepartoServiceImpl implements RepartoService {

    @Autowired
    private RepartoRepo repo;

    @Override
    public List<Reparto> getAllReparti() {
        return repo.findAll();
    }
}
