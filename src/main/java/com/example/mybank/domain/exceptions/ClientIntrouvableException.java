package com.example.mybank.domain.exceptions;

public class ClientIntrouvableException extends RuntimeException {
    public ClientIntrouvableException(int idClient) {
        super("Le clientDatabase avec l'id : " + idClient + " n'existe pas ");
    }
}
