package it.step.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prezzoID;

    private Double valore;
    private Date dataI;
    private Date dataF;

    @ManyToOne
    @JoinColumn(name = "articoloID")
    private Articolo articolo;
}
