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
@Table(name = "Prezzi")
public class Prezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrezzoID")
    private Integer prezzoID;

    @Column(name = "Valore")
    private Double valore;

    @Column(name = "isofferta")
    private Boolean isOfferta;

    @JsonIgnore
    @OneToOne(mappedBy = "prezzo")
    private Articolo articolo;
}
