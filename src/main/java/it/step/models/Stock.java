package it.step.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StockID")
    private Integer stockID;

    @Column(name = "Quantità")
    private Integer quantita;

    @Column(name = "ArticoloID")
    private Integer articoloID;

    public Stock(Integer articoloID, Integer quantita) {
        this.articoloID = articoloID;
        this.quantita = quantita;
    }

}

