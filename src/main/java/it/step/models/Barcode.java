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
public class Barcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barcodeID;

    private String codice;
    private Date DataI;
    private Date DataF;

    @ManyToOne
    @JoinColumn(name = "articoloID")
    private Articolo articolo;
}
