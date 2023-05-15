package com.example.mybank.domain.exceptions;

public class TransactionInexistanteExceptionPourCeCompte extends RuntimeException {
    public TransactionInexistanteExceptionPourCeCompte(int numéroCompte) {
        super("Aucune transaction n'a été effectuée dans ce compte : " + numéroCompte);
    }
}
