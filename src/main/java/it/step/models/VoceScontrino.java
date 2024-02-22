package it.step.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoceScontrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voceScontrinoID;

    private Integer quantita;
    private Double prezzoUnitario;
    private Double totale;

    @ManyToOne
    @JoinColumn(name = "scontrinoID")
    private Scontrino scontrino;

    @ManyToOne
    @JoinColumn(name = "articoloID")
    private Articolo articolo;
}
