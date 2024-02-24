package it.step.controller;

import it.step.models.Incasso;
import it.step.models.Scontrino;
import it.step.models.Stock;
import it.step.models.VoceScontrino;
import it.step.service.ScontrinoService;
import it.step.service.StockService;
import it.step.service.VoceScontrinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private final VoceScontrinoService voceScontrinoService;

    @GetMapping("get/articolo={articoloID}&date={data}")
    public ResponseEntity<Stock> getStockArticoloByData(@PathVariable("articoloID") Integer articoloID, @PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data) {
        try {
            List<VoceScontrino> vociScontrini = voceScontrinoService.getVociScontrinoByData(data);
            Optional<Stock> optionalStock = stockService.getStockByArticoloID(articoloID);
            Stock stock = new Stock();
            if(optionalStock.isPresent()){
                stock = optionalStock.get();
                for(VoceScontrino voce : vociScontrini){
                    if(voce.getArticoloID().equals(stock.getArticoloID())){
                        stock.setQuantita(stock.getQuantita() - voce.getQuantita());
                    }
                }
            } else {
                throw new RuntimeException();
            }
            return new ResponseEntity<>(stock, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
