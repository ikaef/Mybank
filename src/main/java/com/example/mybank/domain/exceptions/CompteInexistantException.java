package com.example.mybank.domain.exceptions;

public class CompteInexistantException extends RuntimeException {
    public CompteInexistantException(int numéroCompte) {
        super("Le numéro de compte "+ numéroCompte + " n'existe pas!");
    }
}
