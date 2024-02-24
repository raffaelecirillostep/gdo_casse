package it.step.service;

import it.step.models.Stock;

import java.util.Optional;


public interface StockService {
    Optional<Stock> getStockByArticoloID(Integer articoloID);
}
