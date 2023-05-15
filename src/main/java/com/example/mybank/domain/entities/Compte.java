package com.example.mybank.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Compte {
    private int numeroCompte;
    private Client client;
    private BigDecimal solde;

}
