package com.example.mybank.use_cases.transaction;

import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.domain.mappers.TransactionDatabaseMapper;
import com.example.mybank.infrastructure.database.transaction.TransactionDatabase;
import com.example.mybank.use_cases.ports.ComptePort;
import com.example.mybank.use_cases.ports.TransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecupererTransactionParCompte {
    private final ComptePort comptePort;
    private final TransactionPort transactionPort;

    public List<Transaction> exécuter(int numéroCompte){
        vérifierExistenceNuméroCompte(numéroCompte);
        return transactionPort.récupérerTransactionParCompte(numéroCompte);
    }
    private void vérifierExistenceNuméroCompte(int numéroCompte){
        comptePort.récupérerCompteParId(numéroCompte);
    }

}
