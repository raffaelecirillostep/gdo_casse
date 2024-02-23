package it.step.controller;

import it.step.models.Articolo;
import it.step.service.ArticoloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/articolo")
@RequiredArgsConstructor
public class ArticoloController {

    private final ArticoloService service;

    @GetMapping("get/{id}")
    public ResponseEntity<Articolo> getArticoloById(@PathVariable("id") Integer id) {
        try {
            Optional<Articolo> articolo = service.getArticoloByID(id);
            if (articolo.isPresent()) {
                return new ResponseEntity<>(articolo.get(), HttpStatus.OK);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("barcode/{code}")
    public ResponseEntity<Articolo> getArticoloByBarcode(@PathVariable("code") String code) {
        try {
            Optional<Articolo> articolo = service.getArticoloByBarcode(code);
            if (articolo.isPresent()) {
                return new ResponseEntity<>(articolo.get(), HttpStatus.OK);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
