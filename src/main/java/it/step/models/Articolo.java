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
@Table(name = "Articoli")
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArticoloID")
    private Integer articoloID;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Grammatura")
    private Double grammatura;

    @Column(name = "unitàmisura")
    private String unitaM;

    @ManyToOne
    @JoinColumn(name = "RepartoID")
    @JsonIgnore
    private Reparto reparto;

    @OneToMany(mappedBy = "articolo")
    private List<Barcode> barcodes;

    @ManyToOne
    @JoinColumn(name = "PrezzoID")
    private Prezzo prezzo;

    @OneToOne(mappedBy = "articolo")
    private Stock stock;
}
