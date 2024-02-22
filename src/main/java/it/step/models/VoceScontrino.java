package it.step.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoceScontrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer voceScontrinoID;

    private Integer quantita;
    private Double prezzoUnitario;
    private Double totale;

    @ManyToOne
    @JoinColumn(name = "scontrinoID")
    @JsonIgnore
    private Scontrino scontrino;

    @ManyToOne
    @JoinColumn(name = "articoloID")
    @JsonIgnore
    private Articolo articolo;
}
