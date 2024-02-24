package it.step.controller;

import it.step.models.Scontrino;
import it.step.models.VoceScontrino;
import it.step.service.ScontrinoService;
import it.step.service.VoceScontrinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/scontrino")
@RequiredArgsConstructor
public class ScontrinoController {

    private final ScontrinoService scontrinoService;
    private final VoceScontrinoService voceScontrinoService;

    @GetMapping("get/{id}")
    public ResponseEntity<Scontrino> getScontrinoById(@PathVariable("id") Integer id) {
        try {
            Optional<Scontrino> scontrino = scontrinoService.getScontrinoByID(id);
            if (scontrino.isPresent()) {
                return new ResponseEntity<>(scontrino.get(), HttpStatus.OK);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "create")
    public ResponseEntity<Scontrino> createScontrino() {
        try {
            Scontrino scontrino = scontrinoService.createScontrino(new Scontrino(new Date(), 0.0));
            return new ResponseEntity<>(scontrino, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Scontrino> deleteScontrinoById(@PathVariable("id") Integer id) {
        try {
            Optional<Scontrino> scontrino = scontrinoService.deleteScontrinoByID(id);
            if (scontrino.isPresent()) {
                return new ResponseEntity<>(scontrino.get(), HttpStatus.OK);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "create/voce")
    public ResponseEntity<VoceScontrino> createVoceScontrino(@RequestBody VoceScontrino voceScontrino) {
        try {
            if (voceScontrino.getScontrinoID() == null || voceScontrino.getArticoloID() == null || voceScontrino.getPrezzoUnitario() == null) {
                throw new RuntimeException();
            }
            VoceScontrino tmp = voceScontrino;

            //Se il totale non viene fornito lo calcolo.
            if (tmp.getTotale() == null) {
                if (tmp.getQuantita() == null) {
                    tmp.setQuantita(1);
                }
                tmp.setTotale(tmp.getPrezzoUnitario() * tmp.getQuantita());
            }
            VoceScontrino voce = voceScontrinoService.saveVoceScontrino(voceScontrino);
            Optional<Scontrino> s = scontrinoService.getScontrinoByID(voceScontrino.getScontrinoID());
            if (s.isPresent()) {
                Scontrino sc = s.get();
                sc.setTotale(sc.getTotale() + voce.getTotale());
                scontrinoService.createScontrino(sc);
            }
            return new ResponseEntity<>(voce, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
