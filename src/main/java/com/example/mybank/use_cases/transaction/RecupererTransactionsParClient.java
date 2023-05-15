package com.example.mybank.use_cases.transaction;

import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.domain.mappers.TransactionDatabaseMapper;
import com.example.mybank.infrastructure.database.transaction.TransactionDatabase;
import com.example.mybank.use_cases.comptes.RecupererLesComptesDUnClient;
import com.example.mybank.use_cases.ports.TransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecupererTransactionsParClient {
    private final TransactionPort transactionPort;
    private final RecupererLesComptesDUnClient recupererLesComptesDUnClient;

    public List<Transaction> exécuter(int idClient) {
        var comptes = recupererLesComptesDUnClient.exécuter(idClient);
        var transactions =
                comptes.stream()
                        .map(compte -> transactionPort.récupérerTransactionParCompte(compte.getNumeroCompte()))
                        .flatMap(List::stream)
                        .toList();
        return transactions;
    }
}
