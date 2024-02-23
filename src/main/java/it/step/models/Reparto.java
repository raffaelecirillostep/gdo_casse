package it.step.models;

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
@Table(name = "Reparti")
public class Reparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RepartoID")
    private Integer repartoID;

    @Column(name = "Nome")
    private String nome;

    @OneToMany(mappedBy = "reparto")
    private List<Articolo> articoli;
}
