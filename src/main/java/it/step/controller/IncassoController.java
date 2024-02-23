package it.step.controller;

import it.step.models.Incasso;
import it.step.models.Scontrino;
import it.step.service.ScontrinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incasso")
@RequiredArgsConstructor
public class IncassoController {

    private final ScontrinoService scontrinoService;

    @GetMapping("date/{data}")
    public ResponseEntity<Incasso> getIncassoByData(@PathVariable("data") @DateTimeFormat(pattern="yyyy-MM-dd") Date data) {
        try {
           List<Scontrino> scontrini = scontrinoService.getScontriniByData(data);
           Incasso incasso = new Incasso(data, 0.0);

           for(Scontrino scontrino : scontrini){
               incasso.setIncasso(incasso.getIncasso() + scontrino.getTotale());
           }
           return new ResponseEntity<>(incasso, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
