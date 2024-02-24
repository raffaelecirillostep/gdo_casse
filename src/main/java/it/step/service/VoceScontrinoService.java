package it.step.service;

import it.step.models.VoceScontrino;

import java.util.Date;
import java.util.List;

public interface VoceScontrinoService {

    VoceScontrino saveVoceScontrino(VoceScontrino voceScontrino);

    List<VoceScontrino> getVociScontrinoByData(Date data);

    List<VoceScontrino> getVociScontrinoByAnno(int anno);
}
