package com.example.mybank.use_cases.ports;

import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.infrastructure.database.transaction.TransactionDatabase;

import java.util.List;
import java.util.UUID;


public interface TransactionPort {
    Transaction récupérerTransactionParId(UUID idTransaction);

    List<Transaction> récupérerTransactionParCompte(int numéroCompte);

    void enregistrerNouvelleTransaction(TransactionDatabase transactionDatabase);
}
