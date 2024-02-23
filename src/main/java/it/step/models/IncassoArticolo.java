package it.step.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncassoArticolo {
    private Integer articoloID;
    private Integer pzVenduti;
    private Double incasso;
}
