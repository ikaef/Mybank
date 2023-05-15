package com.example.mybank.domain.exceptions;

import java.util.UUID;

public class TransactionInexistanteException extends RuntimeException {
    public TransactionInexistanteException(UUID idTransaction) {
        super("La transition avec l'id : " + idTransaction +" n'existe pas");
    }
}
