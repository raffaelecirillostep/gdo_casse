package it.step.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articoloID;

    private String nome;
    private Double grammatura;
    private String unitaM;

    @ManyToOne
    @JoinColumn(name = "repartoID")
    private Reparto reparto;

    @OneToMany(mappedBy = "articolo")
    private List<Barcode> barcodes;

    @OneToMany(mappedBy = "articolo")
    private List<Prezzo> prezzi;

    @OneToMany(mappedBy = "articolo")
    private List<Stock> stocks;

    @OneToMany(mappedBy = "articolo")
    private List<VoceScontrino> vociScontrino;
}
