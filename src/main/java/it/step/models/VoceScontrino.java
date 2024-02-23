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
@Table(name = "vociscontrino")
public class VoceScontrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vocescontrinoID")
    private Integer voceScontrinoID;

    @Column(name = "Quantità")
    private Integer quantita;

    @Column(name = "prezzounitario")
    private Double prezzoUnitario;

    @Column(name = "Totale")
    private Double totale;

    @Column(name = "ScontrinoID")
    private Integer scontrinoID;

    @Column(name = "ArticoloID")
    private Integer articoloID;
}
