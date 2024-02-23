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
@Table(name = "Barcodes")
public class Barcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BarcodeID")
    private Integer barcodeID;

    @Column(name = "Codice")
    private String codice;

    @Column(name = "datainiziovalidità")
    private Date DataI;

    @Column(name = "datafinevalidità")
    private Date DataF;

    @ManyToOne
    @JoinColumn(name = "ArticoloID")
    @JsonIgnore
    private Articolo articolo;
}
