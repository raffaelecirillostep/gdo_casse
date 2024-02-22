package it.step.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articoloID;

    private String nome;
    private Double grammatura;
    private String unitaM;

    @ManyToOne
    @JoinColumn(name = "repartoID")
    @JsonIgnore
    private Reparto reparto;

    @OneToMany(mappedBy = "articolo")
    private List<Barcode> barcodes;

    @OneToMany(mappedBy = "articolo")
    private List<Prezzo> prezzi;

    @OneToMany(mappedBy = "articolo")
    private List<Stock> stocks;

    @JsonIgnore
    @OneToMany(mappedBy = "articolo")
    private List<VoceScontrino> vociScontrino;
}
