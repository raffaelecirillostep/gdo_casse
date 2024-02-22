package it.step.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Barcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer barcodeID;

    private String codice;
    private Date DataI;
    private Date DataF;

    @ManyToOne
    @JoinColumn(name = "articoloID")
    @JsonIgnore
    private Articolo articolo;
}
