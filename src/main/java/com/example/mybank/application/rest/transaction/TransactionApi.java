package com.example.mybank.application.rest.transaction;

import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionApi {

   /* { Pour tester avec Postman
        "opération" : "DEOT",
        "numéroCompte" : 5,
        "montant" :100
    }*/

    private String opération;
    @Min(0)
    private int numéroCompte;
    @Min(0)
    private BigDecimal montant;

}