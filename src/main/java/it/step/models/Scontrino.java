package it.step.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Scontrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scontrinoID;

    private Date data;
    private Double totale;

    @OneToMany(mappedBy = "scontrino")
    private List<VoceScontrino> vociScontrino;
}
