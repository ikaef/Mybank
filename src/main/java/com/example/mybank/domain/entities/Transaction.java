package com.example.mybank.domain.entities;

import com.example.mybank.domain.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Transaction {
    private UUID idTransaction;
    private Operation operation;
    private Compte compte;
    private BigDecimal montant;
}
