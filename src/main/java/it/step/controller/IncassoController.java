package it.step.controller;

import it.step.models.*;
import it.step.service.ArticoloService;
import it.step.service.RepartoService;
import it.step.service.ScontrinoService;
import it.step.service.VoceScontrinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/incasso")
@RequiredArgsConstructor
public class IncassoController {

    private final ScontrinoService scontrinoService;
    private final ArticoloService articoloService;
    private final VoceScontrinoService voceScontrinoService;
    private final RepartoService repartoService;

    @GetMapping("date/{data}")
    public ResponseEntity<Incasso> getIncassoByData(@PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data) {
        try {
            List<Scontrino> scontrini = scontrinoService.getScontriniByData(data);
            Incasso incasso = new Incasso(data, 0.0);

            for (Scontrino scontrino : scontrini) {
                incasso.setIncasso(incasso.getIncasso() + scontrino.getTotale());
            }
            return new ResponseEntity<>(incasso, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("articoli/date/{data}")
    public ResponseEntity<List<IncassoArticolo>> getIncassoArticoliByData(@PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data) {
        try {
            List<Articolo> articoliList = articoloService.getAllArticoli();
            List<VoceScontrino> vociScontrinoList = voceScontrinoService.getVociScontrinoByData(data);
            List<IncassoArticolo> incassoArticoli = new ArrayList<>();

            for (Articolo articolo : articoliList) {
                IncassoArticolo incassoArticolo = new IncassoArticolo(articolo.getArticoloID(), 0, 0.0);
                for (VoceScontrino voceScontrino : vociScontrinoList) {
                    if (articolo.getArticoloID().equals(voceScontrino.getArticoloID())) {
                        incassoArticolo.setPzVenduti(
                                incassoArticolo.getPzVenduti() + voceScontrino.getQuantita()
                        );
                        incassoArticolo.setIncasso(
                                incassoArticolo.getIncasso() + voceScontrino.getTotale()
                        );
                    }
                }
                incassoArticoli.add(incassoArticolo);
            }

            return new ResponseEntity<>(incassoArticoli, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("reparto/date/{data}")
    public ResponseEntity<List<IncassoReparto>> getIncassoRepartoByData(@PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data) {
        try {
            List<Articolo> articoliList = articoloService.getAllArticoli();
            List<VoceScontrino> vociScontrinoList = voceScontrinoService.getVociScontrinoByData(data);
            List<Reparto> repartiList = repartoService.getAllReparti();
            List<IncassoReparto> incassoReparti = new ArrayList<>();

            for (Articolo articolo : articoliList) {
                for (Reparto reparto : repartiList) {
                    if(articolo.getRepartoID().equals(reparto.getRepartoID())){
                        IncassoReparto incassoReparto = new IncassoReparto(reparto.getRepartoID(), 0.0);
                        for (VoceScontrino voceScontrino : vociScontrinoList) {
                            if (articolo.getArticoloID().equals(voceScontrino.getArticoloID())) {
                                incassoReparto.setIncasso(
                                        incassoReparto.getIncasso() + voceScontrino.getTotale()
                                );
                            }
                        }
                        incassoReparti.add(incassoReparto);
                    }
                }

            }

            return new ResponseEntity<>(incassoReparti, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
