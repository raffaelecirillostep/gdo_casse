package it.step.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockID;

    private Integer quantita;

    @ManyToOne
    @JoinColumn(name = "articoloID")
    private Articolo articolo;
}
