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
public class Prezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prezzoID;

    private Double valore;
    private Date dataI;
    private Date dataF;

    @ManyToOne
    @JoinColumn(name = "articoloID")
    @JsonIgnore
    private Articolo articolo;
}
