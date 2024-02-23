package it.step.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Scontrini")
public class Scontrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScontrinoID")
    private Integer scontrinoID;

    @Column(name = "Data")
    private Date data;

    @Column(name = "Totale")
    private Double totale;

    @OneToMany
    @JoinColumn(name = "ScontrinoID", referencedColumnName = "scontrinoID")
    private List<VoceScontrino> vociScontrino;

    public Scontrino(Date data) {
        this.data = data;
    }
}
