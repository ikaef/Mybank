package com.example.mybank.domain.exceptions;

public class OperationMalSaisieException extends RuntimeException {
    public OperationMalSaisieException(String opération) {
        super(String.format("L'opération '%s' n'est pas gérée.", opération ));
    }
}
