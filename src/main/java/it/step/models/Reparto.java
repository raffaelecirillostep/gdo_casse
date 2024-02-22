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
public class Reparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer repartoID;

    private String nome;

    @OneToMany(mappedBy = "reparto")
    private List<Articolo> articoli;
}
