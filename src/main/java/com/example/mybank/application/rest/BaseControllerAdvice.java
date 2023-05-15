package com.example.mybank.application.rest;

import com.example.mybank.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class BaseControllerAdvice {

    @ExceptionHandler({ClientIntrouvableException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErreurReponseApi handleClientIntrouvableException(ClientIntrouvableException exception) {
        return ErreurReponseApi.builder()
                .erreur(ErreurApi.CLIENT_INTROUVABLE)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler({CompteInexistantException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErreurReponseApi handleCompteInexistantException(CompteInexistantException exception) {
        return ErreurReponseApi.builder()
                .erreur(ErreurApi.COMPTE_INEXISTANT)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler({CompteInexistantPourCeClientException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErreurReponseApi handleCompteInexistantPourCeClientException(CompteInexistantPourCeClientException exception) {
        return ErreurReponseApi.builder()
                .erreur(ErreurApi.COMPTE_INEXISTANT_POUR_CE_CLIENT)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler({TransactionInexistanteException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErreurReponseApi handleTransactionInexistanteException(TransactionInexistanteException exception) {
        return ErreurReponseApi.builder()
                .erreur(ErreurApi.TRANSACTION_INEXTISTANTE)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler({TransactionInexistanteExceptionPourCeCompte.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErreurReponseApi handleTransactionInexistanteExceptionPourCeCompte(TransactionInexistanteExceptionPourCeCompte exception) {
        return ErreurReponseApi.builder()
                .erreur(ErreurApi.TRANSACTION_INEXTISTANTE_POUR_CE_COMPTE)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler({OperationMalSaisieException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErreurReponseApi handleOperationMalSaisieException(OperationMalSaisieException exception) {
        return ErreurReponseApi.builder()
                .erreur(ErreurApi.OPERATION_MAL_SAISIE)
                .message(exception.getMessage())
                .build();
    }

}
