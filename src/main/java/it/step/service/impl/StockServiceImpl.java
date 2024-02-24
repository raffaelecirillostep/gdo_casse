package it.step.service.impl;

import it.step.models.Stock;
import it.step.repository.StockRepo;
import it.step.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepo repo;

    @Override
    public Optional<Stock> getStockByArticoloID(Integer articoloID) {
        return repo.findByArticoloID(articoloID);
    }
}
