package com.example.mybank.domain.exceptions;

public class CompteInexistantPourCeClientException extends RuntimeException {

    public CompteInexistantPourCeClientException(int idClient) {
        super("CompteDatabase inexistant pour ce clientDatabase : " + idClient);



    }
}
