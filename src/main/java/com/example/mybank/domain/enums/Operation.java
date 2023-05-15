package com.example.mybank.domain.enums;

import com.example.mybank.domain.exceptions.OperationMalSaisieException;

public enum Operation {
    RETRAIT,
    DEPOT;

    public boolean estUnRetrait() {
        return Operation.RETRAIT.equals(this);
    }

    public boolean estUnDepot() {
        return Operation.DEPOT.equals(this);
    }

    public static Operation of(String opération) {
        return switch (opération) {
            case "RETRAIT" -> Operation.RETRAIT;
            case "DEPOT" -> Operation.DEPOT;
            default -> throw new OperationMalSaisieException(opération);
        };
    }


}
